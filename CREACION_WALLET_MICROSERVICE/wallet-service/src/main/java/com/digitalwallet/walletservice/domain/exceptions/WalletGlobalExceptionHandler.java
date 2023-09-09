package com.digitalwallet.walletservice.domain.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class WalletGlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<WalletError> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        return new ResponseEntity<>(new WalletError(HttpStatus.BAD_REQUEST
                , "Los valores ingresados son incorrectos"
                , errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(WalletGenericClientException.class)
    public ResponseEntity<WalletError> handleClientGenericError(WalletGenericClientException ex){
        HttpStatus status = ex.getHttpStatus();
        String message = ex.getMessage();
        WalletError walletError = new WalletError(status, message);
        if (ex.getCode()!=null || !"".equals(ex.getCode())){
            walletError = new WalletError(status,message,ex.getCode());
        }
        return new ResponseEntity<>(walletError, walletError.getStatus());
    }
}
