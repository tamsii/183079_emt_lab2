package com.finki.ukim.mk.lab2.repository;
import com.finki.ukim.mk.lab2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}