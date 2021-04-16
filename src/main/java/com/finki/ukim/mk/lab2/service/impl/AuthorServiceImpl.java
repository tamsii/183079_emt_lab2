package com.finki.ukim.mk.lab2.service.impl;


import com.finki.ukim.mk.lab2.model.Author;
import com.finki.ukim.mk.lab2.model.Country;
import com.finki.ukim.mk.lab2.model.ex.CountryNotFound;
import com.finki.ukim.mk.lab2.repository.AuthorRepository;
import com.finki.ukim.mk.lab2.repository.CountryRepository;
import com.finki.ukim.mk.lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

}