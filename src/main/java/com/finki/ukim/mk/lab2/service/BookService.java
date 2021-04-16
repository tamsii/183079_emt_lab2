package com.finki.ukim.mk.lab2.service;

import com.finki.ukim.mk.lab2.model.Book;
import com.finki.ukim.mk.lab2.model.dto.BookDto;
import com.finki.ukim.mk.lab2.model.enumerations.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Long id);


    Optional<Book> save(String name, Category category, Long author, Integer availableCopies);


    Optional<Book> edit(Long id, String name, Category category,Long author, Integer availableCopies);

    void decreaseAvailableCopies(Long id);

    void deleteById(Long id);
}