package com.example.springdatabasedockerdemoapi.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity(name = "department")
public class Department {

    @Id
    private int id;
    private String name;
}
