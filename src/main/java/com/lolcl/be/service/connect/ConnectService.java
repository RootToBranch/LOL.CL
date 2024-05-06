package com.lolcl.be.service.connect;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

public interface ConnectService { 
    public <T> ResponseEntity<T> connect(@NonNull String url, T type);
}