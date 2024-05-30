package com.ospl.__student.controller;

import com.ospl.__student.dto.Student;
import com.ospl.__student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    //Add Student
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    //Get Student By id
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudent(id);
    }

    //Update Student Details
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    //Remove Student by id
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }

    //Get List of Students
    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    //Remove All Students
    @DeleteMapping
    public String deleteAllStudents(){
        return service.deleteAllStudents();
    }

}
