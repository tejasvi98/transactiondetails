package com.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.exception.InvalidUserException;
import com.mvp.exception.TransactionNotFoundException;
import com.mvp.feign.LoginClient;
import com.mvp.model.AuthResponse;
import com.mvp.model.TransactionDetail;
import com.mvp.model.TransactionDetailDTO;
import com.mvp.repo.TransactionRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepo repo;
	@Autowired
	private LoginClient login;
	@Autowired
	private TransactionDetail transaction;

	@Override
	public String createTransaction(String token,TransactionDetailDTO transactionDetail) throws InvalidUserException{
		
		if(verifyUser(token,transactionDetail.getUserName())) {
			transaction.setTransactionAmount(transactionDetail.getTransactionAmount());
			transaction.setTransactionDate(transactionDetail.getTransactionDate());
			transaction.setTransactionId(transactionDetail.getTransactionId());
			transaction.setUserName(transactionDetail.getUserName());
			transaction.setVendorName(transactionDetail.getVendorName());
			repo.save(transaction);
		return "Transaction Successful";
		}
		else
			throw new InvalidUserException("Invalid user");
	}
	
	@Override
	public List<TransactionDetail> getTransactionDetails(String userName) throws TransactionNotFoundException {
		
		List<TransactionDetail> transactionDet = repo.findByUserName(userName);
		if(transactionDet.isEmpty()) {
			throw new TransactionNotFoundException("no transaction found for the user");
		}
		return transactionDet;
		
	}
	private boolean verifyUser(String token,String username) {
		AuthResponse auth = login.verifyToken(token).getBody();
		if(auth == null)
			throw new NullPointerException();
		if (!auth.isValid())
			return false;
		else return auth.getUsername().equals(username);
			
		
	}


}
