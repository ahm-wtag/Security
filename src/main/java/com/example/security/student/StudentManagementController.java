package com.example.security.student;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS_LIST = Arrays.asList(
            new Student(1, "Mahdi"),
            new Student(2, "Ahmed"),
            new Student(3, "Sarah"),
            new Student(4, "Alam")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public List<Student> getStudentsList() {
        return STUDENTS_LIST;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write','course:write')")
    public void createNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }


}
