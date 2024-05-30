package com.ospl.__employee.controller;

import com.ospl.__employee.service.EmployeeService;
import com.ospl.__employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //Add Employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    //Get Employee by Id
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }

    //Update Employee
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    //Delete Employee By Id
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    //Get All Employees
    @GetMapping("/employee")
    public List<Employee> getAll(){
        return service.getAllEmployee();
    }

    //Delete All Employees
    @DeleteMapping("/employee")
    public String deleteAll(){
        return service.deleteAll();
    }
}
