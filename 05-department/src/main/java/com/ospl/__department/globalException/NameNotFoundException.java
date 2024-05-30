package com.ospl.__department.globalException;

public class NameNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Given Name is Not Found";
    }
}
