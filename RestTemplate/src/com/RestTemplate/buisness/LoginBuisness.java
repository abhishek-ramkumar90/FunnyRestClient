package com.RestTemplate.buisness;

import com.RestTemplate.dao.LoginProcessor;
import com.RestTemplate.dummyprocessor.LoginDummyrocessor;
import com.RestTemplate.integratedprocessor.LoginIntegratedProcessor;
import com.RestTemplate.request.LoginRequest;
import com.RestTemplate.response.LoginResponse;
import com.RestTemplate.utility.ApplicationContextUtil;

public class LoginBuisness {

    private volatile static LoginBuisness instance = null;
    
    public static LoginBuisness getInstance() {
        if (instance == null) {
            instance = new LoginBuisness();
        }
        return instance;
    }
 
    protected Object readResolve() {
        return instance;
    }
    
    private LoginBuisness(){
    	
    }
	
	public LoginResponse authenticateUser(LoginRequest loginRequest){
		
		LoginResponse response=getLoginProcessor().authenticateUser(loginRequest);
		
		return response;
	}
	
	
	private LoginProcessor getLoginProcessor(){
		
		String type=ApplicationContextUtil.getProperty("serviceType");
		if("DUMMY".equalsIgnoreCase(type)){
			return new LoginDummyrocessor();
		}else if("LIVE".equalsIgnoreCase(type)){
			return new LoginIntegratedProcessor();
		}
		
		return null;
		
	}
}
