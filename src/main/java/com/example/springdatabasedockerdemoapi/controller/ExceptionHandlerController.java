package com.example.springdatabasedockerdemoapi.controller;

import com.example.springdatabasedockerdemoapi.exceptions.NoRecordFoundException;
import com.example.springdatabasedockerdemoapi.exceptions.StudentNotFoundException;
import com.example.springdatabasedockerdemoapi.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity handlesError_1(Exception exception) {
        log.error(exception.getMessage());
        Response response = Response.builder().httpStatusCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage()).errorCode(HttpStatus.NOT_FOUND.getReasonPhrase()).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity handlesError_2(Exception exception) {
        log.error(exception.getMessage());
        Response response = Response.builder().httpStatusCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage()).errorCode(HttpStatus.NOT_FOUND.getReasonPhrase()).build();
        return ResponseEntity.accepted().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlesError_3(Exception exception) {
        log.error(exception.getMessage());
        Response response = Response.builder().httpStatusCode(HttpStatus.BAD_REQUEST.value()).
                message(exception.getMessage()).errorCode(HttpStatus.BAD_REQUEST.getReasonPhrase()).build();
        return ResponseEntity.badRequest().body(response);
    }
}
