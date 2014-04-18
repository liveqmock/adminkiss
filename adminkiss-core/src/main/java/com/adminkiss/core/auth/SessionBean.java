package com.adminkiss.core.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * session记录登录信息
 */
public class SessionBean {

	
	private Map<String, Long> onlineSession = new HashMap<String, Long>();//在线
	
	private Map<Long, String> onlineUser = new HashMap<Long, String>();//在线
	
	public Map<String, Long> getOnlineSession() {
		return onlineSession;
	}

	public void setOnlineSession(Map<String, Long> onlineSession) {
		this.onlineSession = onlineSession;
	}

	public Map<Long, String> getOnlineUser() {
		return onlineUser;
	}

	public void setOnlineUser(Map<Long, String> onlineUser) {
		this.onlineUser = onlineUser;
	}

}