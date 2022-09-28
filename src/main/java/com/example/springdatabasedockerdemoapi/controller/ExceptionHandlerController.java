package com.example.springdatabasedockerdemoapi.controller;

import com.example.springdatabasedockerdemoapi.exceptions.NoRecordFoundException;
import com.example.springdatabasedockerdemoapi.exceptions.StudentNotFoundException;
import com.example.springdatabasedockerdemoapi.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity handlesError_1(Exception exception) {
        log.error(exception.getMessage());
        Response response = Response.builder().code(HttpStatus.BAD_REQUEST.value()).message(exception.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity handlesError_2(Exception exception) {
        log.error(exception.getMessage());
        Response response = Response.builder().code(HttpStatus.ACCEPTED.value()).message(exception.getMessage()).build();
        return ResponseEntity.accepted().body(response);
    }
}
