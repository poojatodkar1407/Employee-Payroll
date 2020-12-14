package com.bl.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private String message;
    private String statusCode;
    private Object object;

    public ResponseDto(String message, String code,Object o) {
        this.message = message;
        this.statusCode = code;
        this.object = o;
    }
}
