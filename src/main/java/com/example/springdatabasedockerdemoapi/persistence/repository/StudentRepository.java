package com.example.springdatabasedockerdemoapi.persistence.repository;

import com.example.springdatabasedockerdemoapi.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public boolean deleteById(int id);

}
