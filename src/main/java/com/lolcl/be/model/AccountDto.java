package com.lolcl.be.model;

import lombok.Builder;

@Builder
public record AccountDto(
    String puuid,
    String gameName,
    String tagLine
) {}