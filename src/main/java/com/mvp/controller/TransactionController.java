package com.mvp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.exception.InvalidUserException;
import com.mvp.exception.TransactionNotFoundException;
import com.mvp.feign.LoginClient;
import com.mvp.model.AuthResponse;
import com.mvp.model.TransactionDetail;
import com.mvp.model.TransactionDetailDTO;
import com.mvp.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private LoginClient login;

	@PostMapping("/transaction")
	public ResponseEntity<String> performTransaction(@RequestHeader("Authorization") String token,
			@RequestBody TransactionDetailDTO transactionDetail) throws InvalidUserException {
		return ResponseEntity.ok(transactionService.createTransaction(token, transactionDetail));
	}

	@GetMapping("/viewTransaction/{username}")
	public List<TransactionDetail> viewTransaction(@RequestHeader("Authorization") String token,
			@PathVariable("username") String userName) throws InvalidUserException, TransactionNotFoundException {

		AuthResponse auth = login.verifyToken(token).getBody();
		if(auth == null)
			throw new NullPointerException();
		if (!auth.isValid())
			throw new InvalidUserException("User is invalid");
		else {
			return transactionService.getTransactionDetails(userName);
		}

	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome, create transaction";
	}

}
