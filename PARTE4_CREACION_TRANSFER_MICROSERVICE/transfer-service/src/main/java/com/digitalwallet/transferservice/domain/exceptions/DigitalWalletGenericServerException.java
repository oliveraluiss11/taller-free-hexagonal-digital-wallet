package com.digitalwallet.transferservice.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class DigitalWalletGenericServerException extends RuntimeException{
    private final HttpStatus httpStatus;
    private String code;
    public DigitalWalletGenericServerException(String message){
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    public DigitalWalletGenericServerException(String message, String code){
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
    }
}
