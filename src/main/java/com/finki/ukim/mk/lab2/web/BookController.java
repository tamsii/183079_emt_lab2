package com.finki.ukim.mk.lab2.web;

import com.finki.ukim.mk.lab2.model.Book;
import com.finki.ukim.mk.lab2.model.dto.BookDto;
import com.finki.ukim.mk.lab2.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> findAll(Pageable pageable){
        return this.bookService.findAll(pageable).getContent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto.getName(),bookDto.getCategory(), bookDto.getAuthorid(), bookDto.getAvailableCopies()).map(book ->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @GetMapping("/{id}/decreasecopies")
    public ResponseEntity decreaseCopies(@PathVariable Long id){
        this.bookService.decreaseAvailableCopies(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,@RequestBody BookDto bookDto){
        return this.bookService.edit(id,bookDto.getName(),bookDto.getCategory(), bookDto.getAuthorid(), bookDto.getAvailableCopies()).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/categories")
    public List<String> findAll(){
        List<String> categories= new ArrayList<>();
        categories.add("NOVEL");
        categories.add("THRILER");
        categories.add("HISTORY");
        categories.add("FANTASY");
        categories.add("BIOGRAPHY");
        categories.add("CLASSICS");
        categories.add("DRAMA");
        return categories;
    }
}
