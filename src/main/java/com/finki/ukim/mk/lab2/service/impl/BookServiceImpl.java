package com.finki.ukim.mk.lab2.service.impl;

import com.finki.ukim.mk.lab2.model.Author;
import com.finki.ukim.mk.lab2.model.Book;
import com.finki.ukim.mk.lab2.model.dto.BookDto;
import com.finki.ukim.mk.lab2.model.enumerations.Category;
import com.finki.ukim.mk.lab2.model.ex.AuthorNotFound;
import com.finki.ukim.mk.lab2.model.ex.BookIDNotFound;
import com.finki.ukim.mk.lab2.repository.AuthorRepository;
import com.finki.ukim.mk.lab2.repository.BookRepository;
import com.finki.ukim.mk.lab2.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return  this.bookRepository.findById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
            return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long author, Integer availableCopies) {
        Author author1=this.authorRepository.findById(author).orElseThrow(()->new AuthorNotFound(author));
        Book book=new Book(name,category,author1,availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long author, Integer availableCopies) {
        Book book=this.findById(id).orElseThrow(()->new BookIDNotFound(id));
        Author author1=this.authorRepository.findById(author).orElseThrow(()->new AuthorNotFound(author));
        book.setAuthor(author1);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);
        book.setName(name);
        return Optional.of(this.bookRepository.save(book));
    }


    @Override
    public void decreaseAvailableCopies(Long id) {
        Book book=this.findById(id).orElseThrow(()->new BookIDNotFound(id));
        if (book.getAvailableCopies()>0){
            Integer copies = book.getAvailableCopies()-1;
            book.setAvailableCopies(copies);
            this.bookRepository.save(book);
        }

    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);

    }
}