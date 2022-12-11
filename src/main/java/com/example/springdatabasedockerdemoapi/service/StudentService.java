package com.example.springdatabasedockerdemoapi.service;

import com.example.springdatabasedockerdemoapi.dto.StudentRequest;
import com.example.springdatabasedockerdemoapi.persistence.model.Student;
import com.example.springdatabasedockerdemoapi.persistence.repository.StudentRepository;
import com.example.springdatabasedockerdemoapi.exceptions.NoRecordFoundException;
import com.example.springdatabasedockerdemoapi.exceptions.StudentNotFoundException;
import com.example.springdatabasedockerdemoapi.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<Response> saveStudent(StudentRequest studentRequest) {

        Student student = Student.builder()
                .id(studentRequest.getId()).city(studentRequest.getCity())
                .name(studentRequest.getName()).department(studentRequest.getDepartment()).build();
        studentRepository.save(student);
        log.debug("saveStudent finished successfully");
        return ResponseEntity.ok(Response.builder().httpStatusCode(HttpStatus.OK.value()).message("Student saved").build());
    }

    public List<Student> getAllStudentRecords() {
        List<Student> studentList = studentRepository.findAll();
        if (studentList.size() == 0) {
            throw new NoRecordFoundException("No record exists");
        }
        return studentList;
    }

    public ResponseEntity<Response> deleteStudent(Integer stu_id) {
        if (studentRepository.existsById(stu_id)) {
            studentRepository.deleteById(stu_id);
        } else if (!studentRepository.existsById(stu_id)) {
            throw new StudentNotFoundException("student not found with the given id");
        }
        return ResponseEntity.ok(Response.builder().httpStatusCode(HttpStatus.OK.value()).message("student deleted - " + stu_id).build());
    }

    public Student getStudent(@PathVariable("stu_id") int stu_id) {
        Optional<Student> student = studentRepository.findById(stu_id);
        if (!student.isPresent()) {
            throw new NoRecordFoundException("No student found for given stu_id - " + stu_id);
        }
        return student.get();
    }


}
