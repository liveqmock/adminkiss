package com.adminkiss.crm.common;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.adminkiss.core.auth.AuthConst;
import com.adminkiss.core.auth.AuthLoginUser;
import com.adminkiss.core.auth.AuthUtils;
import com.adminkiss.core.auth.SessionFactory;
import com.adminkiss.core.cache.SpyMemcachedClient;
import com.adminkiss.core.utils.StringUtils;

/**
 * 权限验证拦截器
 * 
 */
public class AuthInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	private static Set<String> noAuthPages = new HashSet<String>();
	
	@Autowired
	private SpyMemcachedClient memcachedClient;

	static {
		logger.debug("开始加载不用权限验证就能访问地址。。。。。");
		noAuthPages.add("/");
		noAuthPages.add("/index");
		noAuthPages.add("/error/*");
		noAuthPages.add("/common/*");
		logger.debug("******结束加载不用权限验证就能访问地址******");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String context = request.getContextPath();
		String uri = buildRedirectUrl(context, request.getRequestURI());
		// 判断是否登录系统
		AuthLoginUser user = AuthUtils.getAccountFromSession(request);
		if (user != null) {
			if (!SessionFactory.getInstance().isSameUserLogin(
					request.getSession(), user.getId())) {
				if (AuthUtils.isAjaxRequest(request)) {
					response.setHeader("sessionstatus", "other_login");// 在响应头设置session状态
				} else {
					response.sendRedirect(context + "/login?refurl=" + uri + "&error=" + AuthConst.LOGIN_IS_LOGIN_OTHER_PLACE);
				}
				return false;
			}
			// 过滤无需权限验证的请求
			if (!isAuthNeed(uri)) {
				return true;
			} else {
				// 根据角色,权限，菜单信息，进行权限控制
				Set<String> rights = user.getRight();
				for (String right : rights) {
					if (AuthUtils.isPermission(uri, right)) {
						return true;
					}
				}
				// ajax超时处理
				if (AuthUtils.isAjaxRequest(request)) {
					response.setHeader("authstatus", "noauth_user");// 在响应头设置session状态
				} else {
					response.sendRedirect(context + "/notPermission");
				}
				return false;
			}
		} else {
			// ajax超时处理
			if (AuthUtils.isAjaxRequest(request)) {
				response.setHeader("sessionstatus", "timeout_user");// 在响应头设置session状态
			} else {
				String resUri = context + "/login?refurl=" + uri;
				if (StringUtils.isNotEmpty(request.getQueryString())) {
					resUri = resUri + "?" + request.getQueryString();
				}
				response.sendRedirect(resUri);
			}
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		AuthLoginUser user = AuthUtils.getAccountFromSession(request);
		if (user != null) {
			request.setAttribute(AuthConst.AUTH_ATTR, user);
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
	
	private boolean isAuthNeed(String uri) {
		for (String path : noAuthPages) {
			if (AuthUtils.isPermission(uri, path)) {
				return false;
			}
		}
		return true;
	}
	
	private String buildRedirectUrl(String context, String uri) {
		if(StringUtils.isNotEmpty(context)&&!context.equals("/")) {
			return uri.replace(context, "");
		}
		return uri;
	}

}