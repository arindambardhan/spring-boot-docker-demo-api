package com.example.springdatabasedockerdemoapi.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue
    private int depId;

    private String name;
}
