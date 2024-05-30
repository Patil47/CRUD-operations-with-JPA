package com.ospl.__department.globalException;

public class IdNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Given Id is Not Found";
    }
}
