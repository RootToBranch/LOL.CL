package com.lolcl.be.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMatch {    


    private String gameId;
    private String gameDuration;
    private String gameEndTimestamp;
    private String apartName;

    @SuppressWarnings("unchecked")
    @JsonProperty("metadata")
    private void unPack(String metadata) {
        
    }
    
}
// 15번째가 솔랭