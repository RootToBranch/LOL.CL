package com.lolcl.be.service.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.lolcl.be.model.BizException;
import com.lolcl.be.model.BizExceptionCode;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ConnectApiService implements ConnectService {

    @Value("${riot.apiKey}") 
    private String restKey;

    @Autowired
    private final WebClient webClient;

    @Override
    public <T> ResponseEntity<T> connect(@NonNull String url, T type) {
        ResponseEntity<T> response = webClient.mutate()
                            .baseUrl(url)
                            .build()
                            .get()
                            .accept(org.springframework.http.MediaType.APPLICATION_JSON)
                            .headers(header -> header.add("X-Riot-Token", restKey))
                            .retrieve()
                            .onStatus(status -> status.is4xxClientError() 
                                        || status.is5xxServerError()
                                        , clientResponse -> Mono.just(new BizException(BizExceptionCode.NOT_FOUND_DATA))
                            )
                            // .onStatus(status -> status.is2xxSuccessful(), clientResponse -> Mono.just(new BizException(BizExceptionCode )))           
                            .toEntity(new ParameterizedTypeReference<T>(){})
                            .onErrorResume(e -> {
                                System.out.print("test: ");
                                System.out.println(e);
                                return Mono.error(new BizException(BizExceptionCode.NOT_FOUND_DATA));
                            })
                            // .onErrorReturn(new ResponseEntity<>(HttpStatus.FORBIDDEN))
                            .block();
        return response;
        
    }
}