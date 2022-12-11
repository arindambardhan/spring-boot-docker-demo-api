package com.example.springdatabasedockerdemoapi.controller;


import com.example.springdatabasedockerdemoapi.dto.Response;

import com.example.springdatabasedockerdemoapi.dto.StudentRequest;
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
        log.info("StudentController.save finished successfully");
        return responseEntity;
    }
/*
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudentRecords();
    }

    @RequestMapping(value = "/students/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") int id) {
        log.info("stu_id =>=> {}", id);
        return studentService.deleteStudent(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {

        return studentService.getStudent(id);
    }*/
}
