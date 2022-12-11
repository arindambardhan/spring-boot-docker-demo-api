package com.example.springdatabasedockerdemoapi.persistence.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "student")
@Data
@Builder
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

}
