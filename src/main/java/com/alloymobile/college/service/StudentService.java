package com.alloymobile.college.service;

import com.alloymobile.college.persistence.Student;
import com.alloymobile.college.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Flux<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
