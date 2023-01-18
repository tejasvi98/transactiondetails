package com.mvp.service;

import java.util.List;

import com.mvp.exception.InvalidUserException;
import com.mvp.exception.TransactionNotFoundException;
import com.mvp.model.TransactionDetail;
import com.mvp.model.TransactionDetailDTO;

public interface TransactionService {

	public String createTransaction(String token,TransactionDetailDTO transactionDetail) throws InvalidUserException;
	
	public List<TransactionDetail> getTransactionDetails(String userName) throws TransactionNotFoundException;
}
