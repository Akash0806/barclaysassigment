package com.api.librarymanagement.api;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.dto.BooksDto;
import com.api.librarymanagement.exception.NotFoundException;
import com.api.librarymanagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(EndPoints.Books.URI)
@CrossOrigin
public class BooksController {

	@Autowired
	BookService bookService;

	@GetMapping()
	public ResponseEntity<List<BookDto>> getBooks()  {
		return ResponseEntity.ok(bookService.getBooks());
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> updateUserAndBook(@RequestBody @Valid BookDto bookDto)
			throws NotFoundException {
		BookDto bookDto1 = bookService.saveBook(bookDto);
		return ResponseEntity.ok(bookDto1);
	}


}
