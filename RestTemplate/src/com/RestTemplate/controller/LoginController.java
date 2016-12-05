package com.RestTemplate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RestTemplate.buisness.LoginBuisness;
import com.RestTemplate.constants.Status;
import com.RestTemplate.listeners.ApplicationCache;
import com.RestTemplate.request.BaseRequest;
import com.RestTemplate.request.LoginRequest;
import com.RestTemplate.response.LoginResponse;
import com.RestTemplate.response.ResponseType;

@Controller
@RequestMapping("/loginService")
public class LoginController {

	private static final String LOGIN_USER = "/public/login";
	
	private static final String REFRESHCACHE = "/private/refreshCache";

	@RequestMapping(value = LOGIN_USER, method = RequestMethod.POST)
	public @ResponseBody LoginResponse login(
			@RequestBody LoginRequest loginRequest,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws Exception {

		LoginResponse response = LoginBuisness.getInstance().authenticateUser(
				loginRequest);

		setCacheParameters(response);
		return response;
	}

	private void setCacheParameters(LoginResponse response) {
		String securityId = response.getSecurityId();
		ApplicationCache.setDeviceId(response.getDeviceId(), securityId);
		ApplicationCache.setImeiNumber(response.getImeiNumber(), securityId);
	}

	@RequestMapping(value = REFRESHCACHE, method = RequestMethod.POST)
	public @ResponseBody LoginResponse refreshCache(BaseRequest baseRequest,
			HttpServletRequest servletRequest) {

		LoginResponse loginResponse = new LoginResponse();

		ResponseType status = new ResponseType();

		status.setStatus(Status.SUCCESS.toString());

		status.setMessage(" ");

		loginResponse.setStatus(status);

		return loginResponse;
	}

}
