package com.alloymobile.college.service;

import com.alloymobile.college.persistence.Student;
import com.alloymobile.college.persistence.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Flux<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Mono<Student> addStudent(Student student){
        student.setId(new ObjectId().toString());
        return studentRepository.save(student);
    }

    public Mono<Student> updateStudent(String id,Student student){
        return studentRepository.findById(id).flatMap(s->{
            s.setName(student.getName());
            return studentRepository.save(s);
        });
    }

    public Mono<Void> deleteStudent(String id){
        return studentRepository.deleteById(id);
    }
}
