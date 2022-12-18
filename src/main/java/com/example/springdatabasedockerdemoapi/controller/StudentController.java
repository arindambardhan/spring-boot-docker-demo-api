package com.example.springdatabasedockerdemoapi.controller;


import com.example.springdatabasedockerdemoapi.dto.Response;

import com.example.springdatabasedockerdemoapi.dto.StudentRequest;
import com.example.springdatabasedockerdemoapi.persistence.model.Student;
import com.example.springdatabasedockerdemoapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student-management")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<Response> saveStudent(@RequestBody StudentRequest studentRequest) {
        ResponseEntity responseEntity;
        responseEntity = studentService.saveStudent(studentRequest);
        log.info("saveStudent finished successfully");
        return responseEntity;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = studentService.getAllStudentRecords();
        log.info("getStudents finished successfully");
        return students;
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") int id) {
        ResponseEntity<Response> deleteStudentResponse = studentService.deleteStudent(id);
        return deleteStudentResponse;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        return student;
    }

    @PutMapping("/update-student")
    public ResponseEntity<Response> updateStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentRequest);

    }

}
