package com.api.librarymanagement.services;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.dto.BooksDto;
import com.api.librarymanagement.exception.NotFoundException;
import com.api.librarymanagement.model.Book;
import com.api.librarymanagement.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
	@Autowired BookRepository bookRepository;
	@Autowired  ModelMapper modelMapper;

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

	@Override
	public BookDto getBook(Long id) throws NotFoundException {
		Book book = isBookExistInDB(id);
		return modelMapper.map(book, BookDto.class);
	}

	private Book isBookExistInDB(Long userId) throws NotFoundException {
		Optional<Book> bookOpt = bookRepository.findById(userId);
		if (!bookOpt.isPresent()) {
			throw new NotFoundException("User doesn't exist");
		}
		return bookOpt.get();
	}

	@Override
	public BookDto saveBook(BookDto userBookDto) throws NotFoundException {
	    Book book= modelMapper.map(userBookDto, Book.class);
		bookRepository.save(book);
		return modelMapper.map(book, BookDto.class);
	}


}
