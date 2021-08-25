package com.api.librarymanagement.exception;

import com.api.librarymanagement.dto.ErrorDetail;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
		@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(NotFoundException ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NotAllowedException.class)
	public ResponseEntity<?> resourceNotAllowedPerformAction(NotAllowedException ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return  new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
}
