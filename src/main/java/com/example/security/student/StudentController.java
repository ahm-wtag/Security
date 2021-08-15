package com.example.security.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS_LIST = Arrays.asList(
            new Student(1, "Mahdi"),
            new Student(2, "Ahmed"),
            new Student(3, "Sarah"),
            new Student(4, "Alam")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId ) {
        return STUDENTS_LIST.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow( () -> new IllegalStateException("Student " + studentId + " is not found" ));
    }







}
