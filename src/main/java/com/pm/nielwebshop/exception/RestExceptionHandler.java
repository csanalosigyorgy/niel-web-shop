package com.pm.nielwebshop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationRestErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        log.warn(e.getMessage(), e);
        List<String> errorMessages = e.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ValidationRestErrorMessage("Error during validation", 1003, errorMessages));
    }

    @ExceptionHandler(EntityNotFoundByIdException.class)
    public ResponseEntity<RestErrorMessage> handleEntityNotFoundException(EntityNotFoundByIdException e) {
        log.warn(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new RestErrorMessage(e.getMessage(), 1001));
    }

}
