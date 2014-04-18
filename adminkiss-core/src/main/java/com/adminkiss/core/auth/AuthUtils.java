package com.adminkiss.core.auth;

/**
 * 权限相关工具类
 * 
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.adminkiss.core.utils.Digests;
import com.adminkiss.core.utils.EncodeUtils;
import com.adminkiss.core.utils.StringUtils;

public class AuthUtils {

	public static final String HASH_ALGORITHM = "SHA-1";

	public static final int HASH_INTERATIONS = 1024;
	
	private static final int SALT_SIZE = 8;


	/**
	 * 判断ip是否符合规则
	 * 
	 * @param ip
	 * @param settings
	 * @return
	 */
	public static boolean isPermissionIp(String ip, String settings) {
		String[] rules = settings.split(",");
		if (StringUtils.isEmpty(ip)) {
			return false;
		}
		for (String rule : rules) {
			if (isPermission(ip, rule)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否符合规则
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static boolean isPermission(String from, String to) {
		if (from == null || to == null) {
			return false;
		}
		if (to.endsWith("*")) {
			if (from.startsWith(to.substring(0, to.length() - 1))) {
				return true;
			}
		} else {
			if (from.equals(to)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 清除指定session
	 * 
	 * @param request
	 * @param sessionName
	 */
	public static void clearSession(HttpServletRequest request,
			String sessionName) {
		SessionFactory.getInstance().removeLogin(request.getSession());
		request.getSession().removeAttribute(AuthConst.AUTH_SESSION);
	}
	

	/**
	 * 判断是否是ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		if(request.getHeader("x-requested-with")!=null
				&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证密码是否正确
	 * @param loginUser
	 * @return
	 */
	public static boolean validatePassword(AuthLoginUser loginUser) {
		byte[] salt = EncodeUtils.decodeHex(loginUser.getSalt());
		byte[] hashPassword = Digests.sha1(loginUser.getPlainPassword().getBytes(),
				salt, HASH_INTERATIONS);
		if (EncodeUtils.encodeHex(hashPassword).equals(loginUser.getPassword())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 管理员信息设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	public static void entryptPassword(AuthLoginUser authLoginUser) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		authLoginUser.setSalt(EncodeUtils.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(authLoginUser.getPlainPassword().getBytes(),
				salt, 1024);
		authLoginUser.setPassword(EncodeUtils.encodeHex(hashPassword));
	}
	
	/**
	 * 获取登录管理员用户信息
	 * 
	 * @param request
	 * @return
	 */
	public static AuthLoginUser getAccountFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (AuthLoginUser) session.getAttribute(AuthConst.AUTH_SESSION);
	}
	
	/**
	 * @Title: getAccountId
	 * @Description: 获取登录用户ID
	 * @param request
	 * @return
	 */
	public static Long getAccountId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthLoginUser user = (AuthLoginUser) session.getAttribute(AuthConst.AUTH_SESSION);
		if(null != user) {
			return user.getId();
		}
		return null;
	}

	/**
	 * 设置登录管理员用户信息
	 * 
	 * @param request
	 * @return
	 */
	public static void setAccountToSession(HttpServletRequest request, AuthLoginUser user) {
		SessionFactory.getInstance().addLogin(request.getSession(), user.getId());
		request.getSession().setAttribute(AuthConst.AUTH_SESSION, user);
	}
	
	/**
	 * 移除登录管理员用户信息
	 * 
	 * @param request
	 * @return
	 */
	public static void removeAccountFromSession(HttpServletRequest request) {
		SessionFactory.getInstance().removeLogin(request.getSession());
		request.getSession().removeAttribute(AuthConst.AUTH_SESSION);
	}

}