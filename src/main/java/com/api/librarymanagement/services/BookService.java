package com.api.librarymanagement.services;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.dto.BooksDto;
import com.api.librarymanagement.exception.NotFoundException;

import java.util.List;

public interface BookService {
	List<BookDto> getBooks();
	BookDto saveBook(BookDto userBookDto) throws NotFoundException;
	BookDto getBook(Long id) throws NotFoundException;
}
