package com.mvp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.mvp.exception.InvalidUserException;

class InvalidUserExceptionTest {
	
	
	@Test
	void test_InvalidUserException() {
		InvalidUserException userNotFoundException = new InvalidUserException("invalid user exception");
		assertEquals("invalid user exception", userNotFoundException.getMessage());
	}
}
