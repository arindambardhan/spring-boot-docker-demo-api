package com.example.springdatabasedockerdemoapi.service;

import com.example.springdatabasedockerdemoapi.controller.ExceptionHandlerController;
import com.example.springdatabasedockerdemoapi.dao.Student;
import com.example.springdatabasedockerdemoapi.dao.StudentRepository;
import com.example.springdatabasedockerdemoapi.exceptions.NoRecordFoundException;
import com.example.springdatabasedockerdemoapi.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.http.HttpConnectTimeoutException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                httpStatusCode(String.valueOf(HttpStatus.OK.value())).message("Entity saved").build());

        ResponseEntity<Response> actualResponse = studentService.saveStudent(student);

        assertEquals(actualResponse, expectedResponse);

    }

    @Test
    public void test_getAllStudentRecords_1() {
        NoRecordFoundException noRecordFoundException = assertThrows(NoRecordFoundException.class,
                () -> studentService.getAllStudentRecords());

        assertEquals("No record exists", noRecordFoundException.getMessage());
    }

    @Test
    public void test_getAllStudentRecords_2() {

        StudentService studentService = Mockito.mock(StudentService.class);
        List<Student> studentList = studentService.getAllStudentRecords();

        assertTrue(studentList.isEmpty());

    }

}