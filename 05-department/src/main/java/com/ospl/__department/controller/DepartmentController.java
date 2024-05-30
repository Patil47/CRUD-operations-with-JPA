package com.ospl.__department.controller;

import com.ospl.__department.dto.Department;
import com.ospl.__department.responseStructure.ResponseStructure;
import com.ospl.__department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    //Add Department
    @PostMapping
    public ResponseEntity<ResponseStructure<Department>> addDepartment(@RequestBody Department department){
        return service.addDepartment(department);
    }

    //View Department By id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Department>> getDepartmentById(@PathVariable int id){
        return service.getDepartmentById(id);
    }

    //View Department By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseStructure<Department>> getDepartmentByName(@PathVariable String name){
        return service.getDepartmentByName(name);
    }

    //View All Departments
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Department>>> getAllDepartments(){
        return service.getAllDepartments();
    }

    //Update Department Details
    @PutMapping
    public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department department){
        return service.updateDepartment(department);
    }

    //Removed Department By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteDepartmentByID(@PathVariable int id){
        return service.deleteDepartmentById(id);
    }

    //Removed All Department
    @DeleteMapping
    public ResponseEntity<ResponseStructure<String>> deleteAllDepartments(){
        return service.deleteAllDepartments();
    }


}
