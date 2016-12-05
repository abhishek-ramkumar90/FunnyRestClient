package com.RestTemplate.listeners;

import java.util.HashMap;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;

import com.RestTemplate.model.Ticket;

public class ApplicationCache {

	private static CacheAccess<String, HashMap<String, Object>> cache = null;

	static {
	
		cache = JCS.getInstance("sessionCache");
	}
	
	public static void refreshCache(String newsecurityId, String oldSecurityId) {
		HashMap<String, Object> oldCacheMap = cache.get(oldSecurityId);
		if (oldCacheMap != null) {
			HashMap<String, Object> newCacheMap = new HashMap<String, Object>(
					oldCacheMap);
			newCacheMap.put("oldSecurityId", oldSecurityId);
			cache
					.put(newsecurityId, newCacheMap);
		}
	}

	public static void removeChacheChain(String securityId) {
		HashMap<String, Object> CacheMap = cache
				.get(securityId);
		if (CacheMap != null) {
			String previousSecurityId = (String) CacheMap.get("oldSecurityId");
			if (!("".equalsIgnoreCase(previousSecurityId)) && previousSecurityId !=null ) {
				removeChacheChain(previousSecurityId);
			}
			cache.remove(securityId);
		}
	}

	public static CacheAccess<String, HashMap<String, Object>> getCache() {
		return cache;
	}


	public static String getDeviceId(String securityId) {
		HashMap<String, Object> cacheMap = cache
				.get(securityId);
		if (cacheMap == null) {
			return null;
		}
		return (String) cacheMap.get("deviceId");
	}


	public static void setDeviceId(String deviceId, String securityId) {

		if (cache.get(securityId) == null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("deviceId", deviceId);
			cache.put(securityId, map);
		} else {
			cache.get(securityId)
					.put("deviceId", deviceId);
		}
	}
	
	public static void setTicket(Ticket ticket, String securityId) {

		if (cache.get(securityId) == null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ticket", ticket);
			cache.put(securityId, map);
		} else {
			cache.get(securityId)
					.put("ticket", ticket);
		}

	}
	
	public static Ticket getTicket(String securityId) {
		HashMap<String, Object> cacheMap = cache
				.get(securityId);
		if (cacheMap == null) {
			return null;
		}
		return (Ticket) cacheMap.get("ticket");
	}

	public static void setImeiNumber(String imeiNumber, String securityId) {
		if (cache.get(securityId) == null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("imeiNumber", imeiNumber);
			cache.put(securityId, map);
		} else {
			cache.get(securityId)
					.put("imeiNumber", imeiNumber);
		}
	}
	
	public static String getImeiNumber(String securityId) {
		HashMap<String, Object> cacheMap = cache
				.get(securityId);
		if (cacheMap == null) {
			return null;
		}
		return (String) cacheMap.get("imeiNumber");
	}
}

