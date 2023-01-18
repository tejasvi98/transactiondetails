package com.mvp.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TransactionDetailTest {

	@Test
	void getterTest() {
		TransactionDetail transactionDetail = new TransactionDetail(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8));
		transactionDetail.getTransactionId();
		transactionDetail.getUserName();
		transactionDetail.getVendorName();
		transactionDetail.getTransactionAmount();
		transactionDetail.getTransactionDate();
	}
	
	@Test
	void setterTest() {
		TransactionDetail transactionDetail = new TransactionDetail();
		transactionDetail.setTransactionId(1);
		transactionDetail.setUserName("test");
		transactionDetail.setVendorName("abcd");
		transactionDetail.setTransactionAmount(12345);
		transactionDetail.setTransactionDate(LocalDate.of(2020, 1, 8));
		
	}
	
	@Test
	void toStringTest() {
		TransactionDetail transactionDetail = new TransactionDetail(1, "test", "abcd", 12345, LocalDate.of(2020, 1, 8));
		assertNotNull(transactionDetail.toString());
	}
}
