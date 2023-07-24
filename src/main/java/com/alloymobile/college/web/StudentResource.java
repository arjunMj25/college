package com.alloymobile.college.web;

import com.alloymobile.college.persistence.Student;
import com.alloymobile.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public Flux<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping(value = "/students", consumes = "application/json", produces = "application/json" )
    public Mono<Student> addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping(value = "/students/{id}", consumes = "application/json", produces = "application/json" )
    public Mono<Student> updateStudent(@PathVariable String id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping(value = "/students/{id}")
    public Mono<Void> deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

}
