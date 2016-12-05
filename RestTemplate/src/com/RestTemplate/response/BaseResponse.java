package com.RestTemplate.response;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse {

    
    private String deviceId;
    
    private String imeiNumber;

	private ResponseType status=new ResponseType();

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getImeiNumber() {
		return imeiNumber;
	}

	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}

	public ResponseType getStatus() {
		return status;
	}

	public void setStatus(ResponseType status) {
		this.status = status;
	}



}
