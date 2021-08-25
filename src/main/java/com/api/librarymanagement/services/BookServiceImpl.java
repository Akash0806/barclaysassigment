package com.api.librarymanagement.services;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.dto.BooksDto;
import com.api.librarymanagement.model.Book;
import com.api.librarymanagement.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
	@Autowired BookRepository bookRepository;

	@Override
	  public List<BookDto> getBooks() {
		List<Book> books = bookRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		List<BookDto> bookDtos = books
				.stream()
				.filter(Objects::nonNull)
				.filter(book -> book.getNumberofCopy()>1)
				.map(book -> modelMapper.map(book, BookDto.class))
				.collect(Collectors.toList());
		return bookDtos;
	}
}
