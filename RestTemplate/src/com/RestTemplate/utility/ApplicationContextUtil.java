package com.RestTemplate.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationContextUtil {
private static Properties properties = new Properties();
	
	static {
		properties = new Properties();
		Properties newProeprtyFile = new Properties();
		InputStream inputStream = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			properties = new Properties();
			properties.load(loader.getResourceAsStream("web.properties"));
			try{
				
				newProeprtyFile.load(inputStream);
			}catch(Exception e){
			}
			for(Object key:newProeprtyFile.keySet()){
				properties.setProperty(key.toString(), newProeprtyFile.getProperty(key.toString()));
			}
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	public static void init() {

	}

	public static String getProperty(String name) {
		String property = properties.getProperty(name);
		if (property != null)
			return property.trim();
		else
			return null;
	}

}
