package com.api.librarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorDetail {
	String message;
	String description;
}
