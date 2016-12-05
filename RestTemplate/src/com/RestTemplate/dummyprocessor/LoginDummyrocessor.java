package com.RestTemplate.dummyprocessor;

import com.RestTemplate.constants.Status;
import com.RestTemplate.dao.LoginProcessor;
import com.RestTemplate.request.LoginRequest;
import com.RestTemplate.response.LoginResponse;
import com.RestTemplate.utility.EncryptUtils;

public class LoginDummyrocessor implements LoginProcessor {

	@Override
	public LoginResponse authenticateUser(LoginRequest request) {
		LoginResponse response = null;
		try {
			System.out.println("DummyProcessor");
			response = new LoginResponse();
			response.setSecurityId(EncryptUtils.encrypt("" + Math.random()));
		} catch (Exception e) {
			response = new LoginResponse();
			response.getStatus().setStatus(Status.FAIL.toString());
			response.getStatus().setMessage("Authentication Failed");
		}
		return response;
	}

}
