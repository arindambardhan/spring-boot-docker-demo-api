package com.example.springdatabasedockerdemoapi.service;

import com.example.springdatabasedockerdemoapi.dto.StudentRequest;
import com.example.springdatabasedockerdemoapi.persistence.model.Student;
import com.example.springdatabasedockerdemoapi.persistence.repository.StudentRepository;
import com.example.springdatabasedockerdemoapi.exceptions.RecordNotFoundException;
import com.example.springdatabasedockerdemoapi.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Service
@Slf4j
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<Response> saveStudent(StudentRequest studentRequest) {

        Student student = Student.builder()
                .id(studentRequest.getId())
                .city(studentRequest.getCity())
                .name(studentRequest.getName())
                .department(studentRequest.getDepartment())
                .build();
        studentRepository.save(student);

        log.debug("saveStudent finished successfully");
        return ResponseEntity.ok(Response.builder().httpStatusCode(HttpStatus.OK.value()).build());
    }

    public List<Student> getAllStudentRecords() {
        List<Student> studentList = studentRepository.findAll();
        if (studentList.size() == 0) {
            throw new RecordNotFoundException("No record exists");
        }
        return studentList;
    }


    public ResponseEntity<Response> deleteStudent(int id) {
        if (!studentRepository.existsById(id)) {
            throw new RecordNotFoundException("No record exists with id - " + id);
        }
        studentRepository.deleteById(id);
        return ResponseEntity.ok(Response.builder().httpStatusCode(HttpStatus.OK.value()).message("Record deleted").build());
    }

    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new RecordNotFoundException("No record exists with id - " + id);
        }
        return student.get();
    }

    public ResponseEntity<Response> updateStudent(StudentRequest studentRequest) {

        Optional<Student> student = studentRepository.findById(studentRequest.getId());
        if (student.isPresent()) {
            Student updatedStudent = Student.builder()
                    .id(studentRequest.getId())
                    .name(studentRequest.getName())
                    .city(studentRequest.getCity())
                    .department(studentRequest.getDepartment())
                    .build();
            studentRepository.save(updatedStudent);
            return ResponseEntity.ok(Response.builder()
                    .httpStatusCode(HttpStatus.OK.value()).build());
        }
        return ResponseEntity.ok(Response.builder().
                errorCode(String.valueOf(HttpStatus.NOT_FOUND.value())).message("Student not found").build());
    }
}
