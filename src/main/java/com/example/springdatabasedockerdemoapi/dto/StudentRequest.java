package com.example.springdatabasedockerdemoapi.dto;

import com.example.springdatabasedockerdemoapi.persistence.model.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private int id;
    private String name;
    private String city;
    private Department department;

}
