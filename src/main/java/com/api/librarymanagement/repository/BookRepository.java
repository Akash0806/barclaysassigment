package com.api.librarymanagement.repository;

import com.api.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface BookRepository extends JpaRepository<Book, Long> {
}
