package com.api.librarymanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BooksDto extends ReposeDto {
	List<BookDto> bookDtos;
	public BooksDto(List<BookDto> bookDtos,Integer statusCode){
		this.bookDtos = bookDtos;
		this.statusCode = statusCode;
	}
}
