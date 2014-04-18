package com.adminkiss.crm.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.adminkiss.core.cache.SpyMemcachedClient;


/**
 * 系统初始化
 * 
 */
public class InitSystem {

	@Autowired
	private SpyMemcachedClient memcachedClient;

	public void startup() {
		// 初始化系统
		
	}

	

	public void destroy() {
		memcachedClient.getMemcachedClient().shutdown();
	}

}
