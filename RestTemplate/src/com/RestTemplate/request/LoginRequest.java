package com.RestTemplate.request;

import com.RestTemplate.constants.Login;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LoginRequest extends BaseRequest {
	
	private static final long serialVersionUID = 2425335164065206254L;
	
	private String userId;
	
	private Login loginAdapter;
	
	private String password;
	
	private String saltValue;
	
	private String authType;
	
	private String tokenSerialNo;
	
	private String oldSessionId;
	
	private String gcmTokenNo;
	
	private String mobileDeviceNo;
	
	
	public String getGcmTokenNo() {
		return gcmTokenNo;
	}

	public void setGcmTokenNo(String gcmTokenNo) {
		this.gcmTokenNo = gcmTokenNo;
	}

	public String getMobileDeviceNo() {
		return mobileDeviceNo;
	}

	public void setMobileDeviceNo(String mobileDeviceNo) {
		this.mobileDeviceNo = mobileDeviceNo;
	}

	public String getOldSessionId() {
		return oldSessionId;
	}

	public void setOldSessionId(String oldSessionId) {
		this.oldSessionId = oldSessionId;
	}

	public String getTokenSerialNo() {
		return tokenSerialNo;
	}

	public void setTokenSerialNo(String tokenSerialNo) {
		this.tokenSerialNo = tokenSerialNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSaltValue() {
		return saltValue;
	}

	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}

	public Login getLoginAdapter() {
		return loginAdapter;
	}

	public void setLoginAdapter(Login loginAdapter) {
		this.loginAdapter = loginAdapter;
	}
}
