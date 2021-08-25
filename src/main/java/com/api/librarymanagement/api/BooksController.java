package com.api.librarymanagement.api;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.dto.BooksDto;
import com.api.librarymanagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
