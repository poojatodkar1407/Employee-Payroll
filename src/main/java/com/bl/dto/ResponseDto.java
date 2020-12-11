package com.bl.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private String message;
    private String statusCode;

    public ResponseDto(String message, String code) {
        this.message = message;
        this.statusCode = code;
    }
}
