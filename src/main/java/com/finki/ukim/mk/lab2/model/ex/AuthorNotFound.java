package com.finki.ukim.mk.lab2.model.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorNotFound  extends RuntimeException{
    public AuthorNotFound(Long id) {
        super(String.format("Author with id: %d is not found", id));
    }
}
