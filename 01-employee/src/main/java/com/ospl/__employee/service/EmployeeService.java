package com.ospl.__employee.service;

import com.ospl.__employee.dao.EmployeeDao;
import com.ospl.__employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public Employee addEmployee(Employee employee){
       return dao.addEmployee(employee);
    }

    public Employee getEmployee(int id){
        Optional<Employee> employee = dao.getEmployee(id);
        if (employee.isPresent()){
            return employee.get();
        }
        return null;
    }

    public Employee updateEmployee(Employee employee){
        return dao.updateEmployee(employee);
    }

    public String deleteEmployee(int id){
        return dao.deleteEmployee(id);
    }

    public List<Employee> getAllEmployee(){
        return dao.getEmployees();
    }

    public String deleteAll(){
        return dao.deleteAll();
    }
}
