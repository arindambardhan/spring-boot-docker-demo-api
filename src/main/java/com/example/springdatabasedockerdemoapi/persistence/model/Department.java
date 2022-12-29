package com.example.springdatabasedockerdemoapi.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private int id;
    private String name;
}
