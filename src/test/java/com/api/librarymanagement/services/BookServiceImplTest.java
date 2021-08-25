package com.api.librarymanagement.services;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.model.Book;
import com.api.librarymanagement.repository.BookRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

	@InjectMocks
	BookServiceImpl bookService;
	@Mock
	BookRepository bookRepository;



	@Test
	public void shouldReturnEmptyBookList() {
		when(bookRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
		List<BookDto> bookDtos=bookService.getBooks();
		assertThat(bookDtos.isEmpty(),is(true));
	}

	@Test
	public void shouldReturnNotEmptyBookList() {
		Book book = new Book();
		book.setId(1l);
		book.setName("Test");
		book.setAuthor("AuthorTest");
		List<Book> books = Arrays.asList(book);
		when(bookRepository.findAll()).thenReturn(books);
		List<BookDto> bookDtos = bookService.getBooks();
		assertThat(bookDtos.isEmpty(),is(false));
	}

	@Test
	public void shouldReturnEmptyBookListWhenBookObjectIsNull() {
		List<Book> books = new ArrayList<>();
		books.add(null);
		when(bookRepository.findAll()).thenReturn(books);
		List<BookDto> bookDtos = bookService.getBooks();
		assertThat(bookDtos.isEmpty(),is(true));
	}
}