package com.RestTemplate.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.RestTemplate.listeners.ApplicationCache;
import com.RestTemplate.model.Ticket;

public class RequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String securityId = request.getHeader("securityId");
		
		Ticket ticket=ApplicationCache.getTicket(securityId);
		
		if (ticket == null) {
			request.getContextPath();
		response.sendRedirect(request.getContextPath()+
					"/loginService/public/sessioninvalidate");
			return true;
		}
		
		return true;
	}


}

