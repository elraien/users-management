package com.restapi.usersmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private String message;

    public EntityNotFoundException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
