package com.api.librarymanagement.api;

import com.api.librarymanagement.dto.BookDto;
import com.api.librarymanagement.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class) @WebMvcTest(controllers = BooksController.class)
public class BooksControllerTest {
	@MockBean BookService mockBookService;
	@Autowired private MockMvc mockMvc;

	@Test public void shouldReturnUsersList() throws Exception {
		BookDto bookDto = new BookDto(1L,"M2","RD Sharma",2);
		Mockito.when(mockBookService.getBooks()).
				thenReturn(Arrays.asList(bookDto));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EndPoints.Books.URI);

		mockMvc.perform(requestBuilder).andExpect(status().isOk());
		Mockito.verify(mockBookService, times(1)).getBooks();
	}
}
