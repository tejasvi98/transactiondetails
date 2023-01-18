package com.mvp.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mvp.model.MessageResponse;

import lombok.extern.slf4j.Slf4j;

//global exception handler
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

	/**
	 * to handle unauthorized exception
	 * @param UnauthorizedException
	 * @return ResponseEntity<MessageResponse>
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<MessageResponse> handleInvalidUserExceptions(InvalidUserException ex) {
		log.error("Unauthorized request...");
		return ResponseEntity.badRequest()
				.body(new MessageResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED));
	}

	
	/**
	 * handles exception when authorization token is missing
	 * @param MissingRequestHeaderException
	 * @return ResponseEntity<MessageResponse>
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<MessageResponse> handleTransactionNotFoundException(TransactionNotFoundException ex) {
		log.error("Required Bearer token....");
		return ResponseEntity.badRequest().body(new MessageResponse(ex.getMessage(), HttpStatus.NO_CONTENT));
	}

	
	/**Checks header of the request that the user enters.
	 * handles expires JWT token
	 * @param ExpiredJwtExceptionException
	 * @return ResponseEntity<MessageResponse>
	 */
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(ExpiredJwtException.class)
}
