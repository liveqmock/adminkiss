package com.adminkiss.core.auth;

import javax.servlet.http.HttpSession;

/**
 * session工厂
 * 		用户登录时调用：
 * 			SessionFactory.getInstance().addLogin(httpSession, userid);
 * 		判断用户是否在线
 * 			SessionFactory.getInstance().isOnline(userid);

 */
public class SessionFactory {
	
	private static SessionFactory factory;
	
	private SessionBean sessionBean = new SessionBean();
	
	public synchronized  static SessionFactory getInstance() {
		if (factory == null) {
			factory = new SessionFactory();
		}
		return factory;
	}
	
	public void addLogin(HttpSession session, Long uid){
		this.getSessionBean().getOnlineSession().put(session.getId(), uid);
		this.getSessionBean().getOnlineUser().put(uid, session.getId());
	}
	
	public void removeLogin(HttpSession session){
		this.getSessionBean().getOnlineUser().remove(this.getSessionBean().getOnlineSession().get(session.getId()));
		this.getSessionBean().getOnlineSession().remove(session.getId());
	}
	
	public boolean isLogin(HttpSession session, Long uid) {
		//判断当前sesseion登录用户和uid是否是同一个人，不同就删除当前登录状态用户
		Long currentUid = this.getSessionBean().getOnlineSession().get(session.getId());
		if (currentUid != uid) {
			this.removeLogin(session);
		}
		return this.getSessionBean().getOnlineUser().containsKey(uid);
	}
	
	public boolean isOnline(Long uid) {
		return this.getSessionBean().getOnlineUser().containsKey(uid);
	}
	 
	public boolean isSameUserLogin(HttpSession session, Long uid) {
		String sessionId = this.getSessionBean().getOnlineUser().get(uid);
		if (sessionId !=null && sessionId.equals(session.getId())) {
			return true;
		}
		return false;
	}
	
	public int getLoginCount(){
		return this.getSessionBean().getOnlineUser().size();
	}
	
	public int getOnlineCount(){
		return this.getSessionBean().getOnlineSession().size();
	}
	 
	public SessionBean getSessionBean() {
		return sessionBean;
	}
 
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}