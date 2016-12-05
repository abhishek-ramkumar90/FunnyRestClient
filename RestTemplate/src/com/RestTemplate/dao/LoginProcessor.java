package com.RestTemplate.dao;

import com.RestTemplate.request.LoginRequest;
import com.RestTemplate.response.LoginResponse;


public interface LoginProcessor {
	
	public LoginResponse authenticateUser(LoginRequest request);
}
