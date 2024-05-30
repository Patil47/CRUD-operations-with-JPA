package com.ospl.__student.service;

import com.ospl.__student.dto.Student;
import com.ospl.__student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student){
        return repository.save(student);
    }

    public Student getStudent(int id){
        return repository.findById(id).get();
    }

    public Student updateStudent(Student student){
        return repository.save(student);
    }

    public String deleteStudent(int id){
        repository.deleteById(id);
        return "Deleted Sucessfully";
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public String deleteAllStudents(){
        repository.deleteAll();
        return "Deleted All";
    }
}
