package com.api.librarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	Long id;
	String name;
    String author;
    Integer numberofCopy;
}
