package com.lolcl.be.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BizExceptionCode 
{
    NOT_FOUND_DATA(404, "COMMON-ERROR", "NOT FOUND DATA"),
    Forbidden(403, "Forbidden", "403 Forbiddenq");

    private final int status;
    private final String code;
    private final String message;
    
}
