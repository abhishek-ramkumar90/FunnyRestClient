package com.RestTemplate.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RestTemplate.constants.Status;
import com.RestTemplate.request.BaseRequest;
import com.RestTemplate.response.BaseResponse;
import com.RestTemplate.response.ResponseType;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler({ Exception.class })
	public @ResponseBody BaseResponse handleAllException(Exception ex,@RequestBody BaseRequest request) {

		BaseResponse response=new BaseResponse();
		ResponseType status=new ResponseType();
		ResourceBundle bundle = ResourceBundle.getBundle("ApplicationMessages", new Locale(request.getLanguageCode(),request.getCountryCode()));
		status.setMessage(printMessage(bundle,ex.getLocalizedMessage()));
		status.setStatus(Status.FAIL.toString());
		response.setStatus(status);
		return response;
		
	}
	 private  static String printMessage(ResourceBundle bundle,String messageKey) {
	        return bundle.getString(messageKey);
	    }
	
	

}
