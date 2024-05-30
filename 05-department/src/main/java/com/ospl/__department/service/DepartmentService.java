package com.ospl.__department.service;

import com.ospl.__department.dto.Department;
import com.ospl.__department.globalException.IdNotFoundException;
import com.ospl.__department.globalException.NameNotFoundException;
import com.ospl.__department.globalException.NoDepartmentFoundException;
import com.ospl.__department.repository.DepartmentRepository;
import com.ospl.__department.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public ResponseEntity<ResponseStructure<Department>> addDepartment(Department department){
        Department saveDepartment = repository.save(department);
        ResponseStructure<Department> structure = new ResponseStructure<>();
        if (saveDepartment!=null){
            structure.setStatusCode(HttpStatus.CREATED.value());
            structure.setMessage("Department Added Successfully");
            structure.setBody(saveDepartment);
            return new ResponseEntity(structure,HttpStatus.OK);
        }
        structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
        structure.setMessage("Department Not Added");
        structure.setBody(null);
        return new ResponseEntity<>(structure,HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<ResponseStructure<Department>> getDepartmentById(int id){
        Optional<Department> opt = repository.findById(id);
        if (opt.isPresent()){
            ResponseStructure<Department> structure = new ResponseStructure<>();
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Object Fetched");
            structure.setBody(opt.get());
            return new ResponseEntity<>(structure,HttpStatus.OK);
        }
        throw new IdNotFoundException();
    }

    public ResponseEntity<ResponseStructure<Department>> getDepartmentByName(String name){
        Optional<Department> opt = repository.getDepartmentByName(name);
        if (!opt.isEmpty()){
            ResponseStructure<Department> structure = new ResponseStructure<>();
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Data Fetched");
            structure.setBody(opt.get());
            return new ResponseEntity<>(structure,HttpStatus.OK);
        }
        throw new NameNotFoundException();
    }

    public ResponseEntity<ResponseStructure<List<Department>>> getAllDepartments(){
        List<Department> departments = repository.findAll();
        if (!departments.isEmpty()){
            ResponseStructure<List<Department>> structure = new ResponseStructure<>();
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("List Fetched");
            structure.setBody(departments);
            return new ResponseEntity<>(structure,HttpStatus.OK);
        }
        throw new NoDepartmentFoundException();
    }

    public ResponseEntity<ResponseStructure<Department>> updateDepartment(Department department){
        Department saveDepartment = repository.save(department);
        ResponseStructure<Department> structure = new ResponseStructure<>();
        if (saveDepartment.equals(department)){
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Update Data Successfully");
            structure.setBody(saveDepartment);
            return new ResponseEntity<>(structure,HttpStatus.OK);
        }
        structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
        structure.setMessage("Data Not Updated");
        structure.setBody(null);
        return new ResponseEntity<>(structure,HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<ResponseStructure<String>> deleteDepartmentById(int id){
        Optional<Department> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            ResponseStructure<String> structure = new ResponseStructure<>();
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Department Deleted");
            structure.setBody("Given Department Id is Deleted Successfully");
            return new ResponseEntity<>(structure,HttpStatus.NO_CONTENT);
        }

        throw new IdNotFoundException();
    }

    public ResponseEntity<ResponseStructure<String>> deleteAllDepartments(){
        List<Department> departments = repository.findAll();
        if (departments.isEmpty()){
            throw new NoDepartmentFoundException();
        }
        repository.deleteAll();
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Deleted All Departments");
        structure.setBody("Deleted All Departments");
        return new ResponseEntity<>(structure,HttpStatus.NO_CONTENT);
    }
}
