package com.ospl.__department.globalException;

public class NoDepartmentFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "No Department Present in Database";
    }
}
