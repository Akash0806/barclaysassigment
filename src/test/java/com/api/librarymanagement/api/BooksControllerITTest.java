package com.api.librarymanagement.api;

import com.api.librarymanagement.LibraryManagementApplication;
import com.api.librarymanagement.dto.BooksDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = LibraryManagementApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksControllerITTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAllBooks()
	{
		assertTrue(
				this.restTemplate
						.getForObject("http://localhost:" + port + EndPoints.Books.URI, BooksDto.class)
						.getBookDtos().size() == 3);
	}

}