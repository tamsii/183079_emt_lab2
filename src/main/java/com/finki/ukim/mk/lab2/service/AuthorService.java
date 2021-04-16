package com.finki.ukim.mk.lab2.service;
import com.finki.ukim.mk.lab2.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
}