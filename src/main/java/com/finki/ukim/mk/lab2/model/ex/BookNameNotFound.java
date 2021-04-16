package com.finki.ukim.mk.lab2.model.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNameNotFound extends RuntimeException{
    public BookNameNotFound(String id) {
        super(String.format("Book with name: %d is not found", id));
    }
}