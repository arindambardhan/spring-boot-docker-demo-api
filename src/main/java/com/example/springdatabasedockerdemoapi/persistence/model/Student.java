package com.example.springdatabasedockerdemoapi.dao.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

    private Timestamp timestamp;
}
