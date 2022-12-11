package com.example.springdatabasedockerdemoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response {

    private String message;

    private int httpStatusCode;

    private String errorCode;

}
