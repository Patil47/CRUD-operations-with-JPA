package com.ospl.__department.responseStructure;

import lombok.Data;

@Data
public class ResponseStructure<T> {
    private int statusCode;
    private String message;
    private T body;
}
