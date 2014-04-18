package com.adminkiss.core.auth;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * session监听器
 * 使用方法，在web.xml中添加如下内容
 *	<listener>
 *		<listener-class>com.jiudou.core.util.session.SessionListener</listener-class>
 *	</listener>
 *
 */
public class SessionListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.debug("*********sessionCreated: "+session.getId());
		SessionFactory.getInstance().getSessionBean().getOnlineSession().put(session.getId(), null);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.debug("*********sessionDestroyed: " + session.getId());
		SessionFactory.getInstance().removeLogin(session);
		logger.debug("*********Login User Count: " + SessionFactory.getInstance().getLoginCount());
		logger.debug("*********Online User Count: " + SessionFactory.getInstance().getOnlineCount());
	}

}
