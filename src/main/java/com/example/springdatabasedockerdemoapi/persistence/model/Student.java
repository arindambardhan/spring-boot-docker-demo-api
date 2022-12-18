package com.example.springdatabasedockerdemoapi.persistence.model;



import lombok.*;

import javax.persistence.*;



@Entity
@Table(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String city;

    @JoinColumn
    @OneToOne
    @NonNull
    private Department department;

}
