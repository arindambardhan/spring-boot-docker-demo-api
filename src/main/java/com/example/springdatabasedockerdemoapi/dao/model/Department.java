package com.example.springdatabasedockerdemoapi.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class Department {

    @Id
    @GeneratedValue
    private int dp_id;

    private String dp_name;
}
