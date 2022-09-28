package com.example.springdatabasedockerdemoapi.dao.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
    private int stu_id;

    private String name;

    private String city;
}
