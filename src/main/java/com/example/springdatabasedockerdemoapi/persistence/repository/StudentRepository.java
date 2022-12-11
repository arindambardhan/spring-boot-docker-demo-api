package com.example.springdatabasedockerdemoapi.dao;

import com.example.springdatabasedockerdemoapi.dao.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public boolean deleteById(int id);

}