package com.api.librarymanagement.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class GlobalExceptionHandlerTest {

	/*@BeforeEach void setUp() {
		MockMvc mockMvc = standaloneSetup(myControllers)
				.setHandlerExceptionResolvers(createExceptionResolver())
				.build();
	}
*/
	@Test void resourceNotFoundException() {
	}

	@Test void resourceNotAllowedPerformAction() {
	}

	@Test void globalExceptionHandler() {
	}

	private ExceptionHandlerExceptionResolver createExceptionResolver() {
		ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
			protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
				Method method = new ExceptionHandlerMethodResolver(GlobalExceptionHandler.class).resolveMethod(exception);
				return new ServletInvocableHandlerMethod(new GlobalExceptionHandler(), method);
			}
		};
		exceptionResolver.afterPropertiesSet();
		return exceptionResolver;
	}
}