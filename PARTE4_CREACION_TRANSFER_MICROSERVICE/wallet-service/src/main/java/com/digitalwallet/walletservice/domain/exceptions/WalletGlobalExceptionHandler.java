package com.digitalwallet.walletservice.domain.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class WalletGlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<WalletError> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> fieldError.getField() + ": "+ fieldError.getDefaultMessage()).collect(Collectors.toList());

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

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<WalletError> handleConstraintViolation(
            ConstraintViolationException ex) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }
        WalletError error = new WalletError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<WalletError>(
                error, error.getStatus());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<WalletError> handleAll(Exception ex, WebRequest request) {
        WalletError error = new WalletError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
        return new ResponseEntity<WalletError>(
                error, new HttpHeaders(), error.getStatus());
    }
}
