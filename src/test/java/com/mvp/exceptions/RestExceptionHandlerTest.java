package com.mvp.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mvp.exception.InvalidUserException;
import com.mvp.exception.RestExceptionHandler;
import com.mvp.exception.TransactionNotFoundException;


@SpringBootTest(classes = {RestExceptionHandlerTest.class})
class RestExceptionHandlerTest {

	@Test
	void test_handleTransctionNOtFoundException() {
		TransactionNotFoundException ex = new TransactionNotFoundException("Test_handleUnauthorizedException");
		RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
		restExceptionHandler.handleTransactionNotFoundException(ex);
	}
	
	@Test
	void test_handleInvalidUserException() {
		InvalidUserException ex = new InvalidUserException("Test_handleUnauthorizedException");
		RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
		restExceptionHandler.handleInvalidUserExceptions(ex);
	}
	
	
	
}
