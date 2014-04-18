package com.adminkiss.core.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Http与Servlet工具类。
 */
public class HttpUtils {

	public final static String CHARSET_DEFAULT = "ISO-8859-1";
	
	public final static String CHARSET_UTF8 = "UTF-8";
	
	/**
	 * 获取用户的IP地址
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 设置cookie
	 * 
	 * @param response : 从外部传进来的response对象,不可以为null
	 * @param key : cookie的健
	 * @param value : cookie的值
	 * @param domain : cookie所在的域,可以为null,为null时按时默认的域存储
	 * @param maxAge : cookie最大时效,以秒为单位,为null时表示不设置最大时效,按照浏览器进程结束
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, String domain, Integer maxAge) {
		Cookie cookie = new Cookie(key, value);
		if (domain != null && domain.length() > 0) {
			cookie.setDomain(domain);
		}
		if (maxAge != null) {
			cookie.setMaxAge(maxAge);
		}
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	/**
	 * 从cookie中得到值
	 * 
	 * @param request
	 * @param key :cookie名称
	 * @param domain :域名
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String key, String domain) {
		if (StringUtils.isNotEmpty(key)) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (key.equals(c.getName())) {
						return c.getValue();
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 判断是否是ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		boolean flag = false;
		String requestType = request.getHeader("X-Requested-With");
		if (StringUtils.isNotEmpty(requestType)) {
			requestType = requestType.toLowerCase(); // XMLHttpRequest
			if ("xmlhttprequest".equals(requestType)) {
				flag = true;
			}
		}
		return flag;
	}
	
}