package com.example.springdatabasedockerdemoapi.controller;

import com.example.springdatabasedockerdemoapi.exceptions.RecordNotFoundException;
import com.example.springdatabasedockerdemoapi.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Response> handlesUserExceptions(Exception exception) {
        log.error(exception.getMessage());
        return ResponseEntity.ok(Response.builder()
                .message(exception.getMessage())
                .errorCode(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Response> clientExceptions(Exception exception) {
        log.error(exception.getMessage());
        return ResponseEntity.ok(Response.builder()
                .message(exception.getMessage()).
                errorCode(HttpStatus.BAD_REQUEST.getReasonPhrase()).
                build());
    }
    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Response> serverExceptions(Exception exception) {
        log.error(exception.getMessage());
        return ResponseEntity.ok(Response.builder()
                .message(exception.getMessage()).
                errorCode(HttpStatus.BAD_REQUEST.getReasonPhrase()).
                build());
    }
}
