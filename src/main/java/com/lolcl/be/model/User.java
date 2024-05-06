package com.lolcl.be.model;

import lombok.Builder;

@Builder
public record User(
    String id,
    String accountId,
    String puuid,
    String name,
    long profileIconId,
    long revisionDate,
    long summonerLevel,
    MatchDto matchDto
) {}
