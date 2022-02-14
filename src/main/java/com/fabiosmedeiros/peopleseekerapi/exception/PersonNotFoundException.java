package com.fabiosmedeiros.peopleseekerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// A annotation @ResponseStatus define o código de retorno 401 (NOT_FOUND)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(Long id) {
        super("No Person was found with the ID " + id);
    }

}
