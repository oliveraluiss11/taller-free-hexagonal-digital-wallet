package com.digitalwallet.transferservice.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class DigitalWalletGenericClientException extends RuntimeException{
    private final HttpStatus httpStatus;
    private String code;
    public DigitalWalletGenericClientException(String message, HttpStatus status){
        super(message);
        this.httpStatus = status;
    }
    public DigitalWalletGenericClientException(String message, String code, HttpStatus status){
        super(message);
        this.code = code;
        this.httpStatus = status;
    }
}
