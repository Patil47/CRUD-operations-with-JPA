package com.ospl.__department.exceptionHandler;


import com.ospl.__department.globalException.IdNotFoundException;
import com.ospl.__department.globalException.NameNotFoundException;
import com.ospl.__department.globalException.NoDepartmentFoundException;
import com.ospl.__department.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException idNotFoundException){
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        structure.setMessage(idNotFoundException.getMessage());
        structure.setBody("Id Not Found Exception");
        return new ResponseEntity<>(structure,HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNameNotFoundException(NameNotFoundException nameNotFoundException){
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        structure.setMessage(nameNotFoundException.getMessage());
        structure.setBody("Name Not Found Exception");
        return new ResponseEntity<>(structure,HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoDepartmentFoundException.class)
    public ResponseEntity<ResponseStructure<Object>> handleNoDepartmentFoundException(NoDepartmentFoundException noDepartmentFoundException){
        ResponseStructure<Object> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        structure.setMessage(noDepartmentFoundException.getMessage());
        structure.setBody("No Department Found Exception");
        return new ResponseEntity<>(structure,HttpStatus.BAD_REQUEST);
    }
}
