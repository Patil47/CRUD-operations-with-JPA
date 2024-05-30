package com.ospl.__employee.dao;

import com.ospl.__employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.ospl.__employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee){
        return repository.save(employee);
    }

    public Optional<Employee> getEmployee(int id){
        return repository.findById(id);
    }

    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Deleted";
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public String deleteAll(){
        repository.deleteAll();
        return "Deleted All";
    }
}
