package com.example.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptiopn extends RuntimeException{

    public ResourceNotFoundExceptiopn(String message) {
        super(message);
    }
}
