package com.mvp.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mvp.model.AuthResponse;

@FeignClient(url = "${login.feign.client}", name = "${login.feign.name}")
public interface LoginClient {
	@GetMapping(path = "/validate")
	public ResponseEntity<AuthResponse> verifyToken(
			@RequestHeader(name = "Authorization", required = true) String token);

}