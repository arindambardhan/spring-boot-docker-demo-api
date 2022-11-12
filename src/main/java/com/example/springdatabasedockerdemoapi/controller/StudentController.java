package com.example.springdatabasedockerdemoapi.controller;

import com.example.springdatabasedockerdemoapi.dao.Student;
import com.example.springdatabasedockerdemoapi.model.Response;
import com.example.springdatabasedockerdemoapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/info")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save-student")
    public ResponseEntity<Response> saveStudent(@RequestBody Student student) {
        ResponseEntity responseEntity;
        responseEntity = studentService.saveStudent(student);
        log.info("StudentController.save finished successfully");
        return responseEntity;
    }

    @GetMapping("/students-info")
    public List<Student> getAllStudents() {
        return studentService.getAllStudentRecords();
    }

    @RequestMapping(value = "/delete-student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") Integer stu_id) {
        log.info("stu_id =>=> {}", stu_id);
        return studentService.deleteStudent(stu_id);
    }

    @GetMapping("/student-info/{stu_id}")
    public Student getStudent(@PathVariable("stu_id") int stu_id) {
        return studentService.getStudent(stu_id);
    }
}
