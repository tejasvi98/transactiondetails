package com.mvp.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.anyString;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mvp.exception.InvalidUserException;
import com.mvp.exception.TransactionNotFoundException;
import com.mvp.feign.LoginClient;
import com.mvp.model.AuthResponse;
import com.mvp.model.TransactionDetail;
import com.mvp.model.TransactionDetailDTO;
import com.mvp.service.TransactionServiceImpl;

@SpringBootTest(classes = { TransactionControllerTest.class })
class TransactionControllerTest {

	@Mock
	TransactionServiceImpl transactionService;

	@Mock
	LoginClient login;

	@Spy
	@InjectMocks
	TransactionController transactionController;

	@Test
	void test_createTransaction() throws InvalidUserException {
		TransactionDetailDTO transactionDetail = new TransactionDetailDTO(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8));
		String token = "tokentokentoken";
		when(transactionService.createTransaction(token, transactionDetail)).thenThrow(InvalidUserException.class);
		assertThrows(InvalidUserException.class,
				() -> transactionController.performTransaction(token, transactionDetail));

	}

	@Test
	void test_createTransaction1() throws InvalidUserException {
		AuthResponse auth = new AuthResponse("test", true);
		String token = "tokentokentoken";
		ResponseEntity<AuthResponse> response = new ResponseEntity<AuthResponse>(auth, HttpStatus.OK);
		TransactionDetailDTO transactionDetail = new TransactionDetailDTO(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8));
		when(login.verifyToken(anyString())).thenReturn(response);
		when(transactionService.createTransaction(token, transactionDetail)).thenReturn("Transaction Successful");
		assertEquals("Transaction Successful",
				transactionController.performTransaction(token, transactionDetail).getBody());
	}

	@Test
	void test_viewTransaction() throws TransactionNotFoundException, InvalidUserException {
//		given
		List<TransactionDetail> list = new ArrayList<TransactionDetail>();
		list.add(new TransactionDetail(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8)));
		AuthResponse auth = new AuthResponse("test", true);
		String token = "tokentokentoken";
		ResponseEntity<AuthResponse> response = new ResponseEntity<AuthResponse>(auth, HttpStatus.OK);
//		when
		when(login.verifyToken(token)).thenReturn(response);
		when(transactionService.getTransactionDetails("test")).thenReturn(list);
		assertArrayEquals(list.toArray(), transactionController.viewTransaction(token, "test").toArray());
	}
}
