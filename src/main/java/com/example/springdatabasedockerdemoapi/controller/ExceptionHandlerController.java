package com.example.springdatabasedockerdemoapi.controller;

import com.example.springdatabasedockerdemoapi.exceptions.StudentNotFoundException;
import com.example.springdatabasedockerdemoapi.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "StudentController")
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity handleError(Exception exception) {
        log.error(exception.getMessage());
        Response response = Response.builder().code(HttpStatus.BAD_REQUEST).message(exception.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }
}
