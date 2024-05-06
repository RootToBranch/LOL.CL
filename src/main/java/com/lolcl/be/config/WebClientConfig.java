package com.lolcl.be.config;

// Sources : https://github.com/spring-projects/spring-framework

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.LoggingCodecSupport;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.lolcl.be.util.ThrowingConsumer;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
@Slf4j
public class WebClientConfig {

    @Bean
    public WebClient webClient() {

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                                                                  .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024*1024*50)) //Body Contents Size increase
                                                                  .build();
        exchangeStrategies
            .messageWriters().stream()
            .filter(LoggingCodecSupport.class::isInstance)
            .forEach(writer -> ((LoggingCodecSupport)writer).setEnableLoggingRequestDetails(true)); //Logging Setting

        return WebClient.builder()
                        .clientConnector(
                            new ReactorClientHttpConnector(  // HttpClient Option Edit
                                HttpClient
                                    .create()
                                    .secure(
                                        ThrowingConsumer.unchecked(
                                            sslContextSpec -> sslContextSpec.sslContext(
                                                SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build() //Unsigned SSL approve
                                            )
                                        )
                                    )
                                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 120_000)  //Connection TimeOut
                                        .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(180)) //Read TimeOut
                                                                    .addHandlerLast(new WriteTimeoutHandler(180)) //Write TimeOut
                                        )
                                    
                            )
                        )
                        .exchangeStrategies(exchangeStrategies)
                        .filter(ExchangeFilterFunction.ofRequestProcessor( //Request Header Logging
                            clientRequest -> {
                                log.debug("Request: {} {}", clientRequest.method(), clientRequest.url());
                                clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.debug("{} : {}", name, value)));
                                return Mono.just(clientRequest);
                            }
                        ))
                        .filter(ExchangeFilterFunction.ofResponseProcessor( //Response Header Logging
                            clientResponse -> {
                                clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> log.debug("{} : {}", name, value)));
                                return Mono.just(clientResponse);
                            }
                        ))
                        .defaultHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.3")
                        .build();
    }
}