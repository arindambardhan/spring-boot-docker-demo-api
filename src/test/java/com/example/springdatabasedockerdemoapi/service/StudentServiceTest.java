package com.example.springdatabasedockerdemoapi.service;

import com.example.springdatabasedockerdemoapi.dao.Student;
import com.example.springdatabasedockerdemoapi.dao.StudentRepository;
import com.example.springdatabasedockerdemoapi.model.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpConnectTimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Test
    public void save_test_1() {

        Student student = Student.builder().name("Sam").city("Seoul").stu_id(101).build();

        ResponseEntity<Response> expectedResponse = ResponseEntity.ok(Response.builder().
                httpStatusCode(HttpStatus.OK.value()).message("Entity saved").build());

        ResponseEntity<Response> actualResponse = studentService.saveStudent(student);

        assertEquals(actualResponse, expectedResponse);

    }

    @Test
    public void save_test_2() {

        Student student = Student.builder().name("Sam").city("Seoul").stu_id(101).build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            when(studentService.saveStudent(student)).thenThrow(new HttpConnectTimeoutException(""));
        });
    }

}