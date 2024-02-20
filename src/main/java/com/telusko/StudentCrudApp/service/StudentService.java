package com.telusko.StudentCrudApp.service;

import com.telusko.StudentCrudApp.model.Student;
import com.telusko.StudentCrudApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

//    fetching all students record
    public List<Student> getStudents(){
        return repository.findAll();
    }

//    register student deatils
    public void registerStudent(Student student){
        repository.save(student);
    }

//    get a student by id
    public Student getStudentById(Integer id){
        Optional<Student> studentOptional = repository.findById(id);
        return studentOptional.get();
    }

//    delete student by id
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
