package com.alloymobile.college.web;

import com.alloymobile.college.persistence.Student;
import com.alloymobile.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public Flux<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
}
