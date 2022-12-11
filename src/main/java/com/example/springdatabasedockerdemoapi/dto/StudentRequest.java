package com.example.springdatabasedockerdemoapi.dto;

import com.example.springdatabasedockerdemoapi.persistence.model.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
