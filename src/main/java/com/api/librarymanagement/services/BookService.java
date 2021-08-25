package com.api.librarymanagement.services;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.dto.BooksDto;

import java.util.List;

public interface BookService {
	List<BookDto> getBooks();
}
