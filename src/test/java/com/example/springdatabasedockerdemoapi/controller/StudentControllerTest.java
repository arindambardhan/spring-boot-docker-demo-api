package com.example.springdatabasedockerdemoapi.controller;

import com.example.springdatabasedockerdemoapi.dto.Response;
import com.example.springdatabasedockerdemoapi.dto.StudentRequest;
import com.example.springdatabasedockerdemoapi.exceptions.RecordNotFoundException;
import com.example.springdatabasedockerdemoapi.persistence.model.Department;
import com.example.springdatabasedockerdemoapi.persistence.model.Student;
import com.example.springdatabasedockerdemoapi.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void saveStudent_Student_200OKResponse() {

        StudentRequest studentRequest = StudentRequest
                .builder().id(120)
                .city("abc")
                .name("bcd")
                .department(new Department(101, "Technology"))
                .build();

        ResponseEntity expectedResponse = ResponseEntity.
                ok(Response.builder().httpStatusCode(HttpStatus.OK.value()).build());

        when(studentService.saveStudent(studentRequest)).
                thenReturn(expectedResponse);

        assertEquals(expectedResponse, studentController.saveStudent(studentRequest));
    }

    @Test
    public void getStudents_return_Students() {

        List<Student> students = Arrays.asList(Student.builder()
                .id(120)
                .name("abc")
                .city("bcd")
                .department(new Department(101, "Technology")).build());

        when(studentService.getAllStudentRecords()).thenReturn(students);

        assertEquals(students, studentController.getStudents());
    }

    @Test
    public void deleteStudent_id_200OkResponse() {

        int id = 102;

        ResponseEntity<Response> expectedResponse = ResponseEntity.ok(Response.builder().
                httpStatusCode(HttpStatus.OK.value()).message("Record deleted").build());

        when(studentService.deleteStudent(id)).thenReturn(expectedResponse);

        assertEquals(expectedResponse, studentController.deleteStudent(id));

    }

}