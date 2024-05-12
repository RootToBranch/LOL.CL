package com.lolcl.be.model;

import lombok.Builder;

@Builder
public record SummonerDto(
    String id,
    String accountId,
    String puuid,
    long profileIconId,
    long revisionDate,
    long summonerLevel
){}