package com.RestTemplate.integratedprocessor;

import com.RestTemplate.dao.LoginProcessor;
import com.RestTemplate.request.LoginRequest;
import com.RestTemplate.response.LoginResponse;

public class LoginIntegratedProcessor implements LoginProcessor {

	@Override
	public LoginResponse authenticateUser(LoginRequest request) {
		// TODO Auto-generated method stub
		System.out.println("IntegratedProcessor");
		return null;
	}
}
