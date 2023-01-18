package com.mvp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mvp.exception.TransactionNotFoundException;

class TransactionNotFoundExceptionTest {
	
	@Test
	void test_UnauthorizedException() {
		TransactionNotFoundException userExp = new TransactionNotFoundException("Transaction Not Found");
		assertEquals("Transaction Not Found", userExp.getMessage());
	}
}
