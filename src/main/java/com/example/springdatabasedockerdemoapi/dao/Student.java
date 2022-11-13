package com.example.springdatabasedockerdemoapi.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private int stu_id;
    private String name;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

}
