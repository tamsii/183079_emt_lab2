package com.finki.ukim.mk.lab2.model.dto;

import com.finki.ukim.mk.lab2.model.Author;
import com.finki.ukim.mk.lab2.model.enumerations.Category;
import lombok.Data;


@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorid;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long authorid, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorid = authorid;
        this.availableCopies = availableCopies;
    }
}