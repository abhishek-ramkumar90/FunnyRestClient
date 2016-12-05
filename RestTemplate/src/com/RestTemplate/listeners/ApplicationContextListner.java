package com.RestTemplate.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListner implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Class.forName("com.aurionpro.cashpro.mobile.commons.listener.ApplicationCache");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("ApplicationContextListner ::::::::::::::::::: contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out
				.println("ApplicationContextListner ::::::::::::::::::: contextDestroyed");
	}



}
