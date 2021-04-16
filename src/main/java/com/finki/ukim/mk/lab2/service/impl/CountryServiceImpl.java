package com.finki.ukim.mk.lab2.service.impl;

import com.finki.ukim.mk.lab2.model.Country;
import com.finki.ukim.mk.lab2.repository.CountryRepository;
import com.finki.ukim.mk.lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll() ;
    }


}