package com.mvp.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mvp.exception.InvalidUserException;
import com.mvp.exception.TransactionNotFoundException;
import com.mvp.feign.LoginClient;
import com.mvp.model.AuthResponse;
import com.mvp.model.TransactionDetail;
import com.mvp.model.TransactionDetailDTO;
import com.mvp.repo.TransactionRepo;

@SpringBootTest(classes = { TransactionServiceImplTest.class })
class TransactionServiceImplTest {
	@Mock
	TransactionServiceImpl transactionService;

	@Mock
	LoginClient login;
	
	@Mock
	TransactionRepo transactionrepo;

	@Test
	void createTransaction() throws InvalidUserException {
		TransactionDetailDTO transactionDetail = new TransactionDetailDTO(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8));
		String token = "tokentokentoken";
		when(login.verifyToken(token))
				.thenReturn(new ResponseEntity<AuthResponse>(new AuthResponse("test", true), HttpStatus.OK));
		transactionService.createTransaction(token, transactionDetail);
	}

	@Test
	void test_getTransactions() throws TransactionNotFoundException {
		List<TransactionDetail> list = new ArrayList<>();
		list.add(new TransactionDetail(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8)));
		when(transactionrepo.findByUserName(Mockito.anyString())).thenReturn(list);
		transactionService.getTransactionDetails("test");
	}
}
