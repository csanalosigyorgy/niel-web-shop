package com.pm.nielwebshop.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestErrorMessage {

    protected LocalDateTime timeStamp;
    protected String message;
    protected Integer code;

    public RestErrorMessage(String message, Integer code) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.code = code;
    }

}
