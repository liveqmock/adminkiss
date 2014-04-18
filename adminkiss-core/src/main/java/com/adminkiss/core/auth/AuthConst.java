package com.adminkiss.core.auth;

/**
 * 权限常量
 *
 */
public class AuthConst {
	
	/** 登录状态错误码 **/
	public final static int LOGIN_FAILURE = 0;// 用户名或密码不正确
	public final static int LOGIN_SUCCESS = 1;// 登录成功
	public final static int LOGIN_USERNAME_OR_PASSWORD_EMPTY = 2;// 登录时，用户名或密码为空
	public final static int LOGIN_USER_NOT_FOUND = 3;// 登录时，登录用户不存在
	public final static int LOGIN_ACCOUNT_UNUSED = 4;// 账号不可用
	public final static int LOGIN_ACCOUNT_FREEZE = 5;// 账号冻结不可用
	public final static int LOGIN_IS_LOGIN_OTHER_PLACE= 6;// 账号在其他地方登录

	/** session常量 **/
	public final static String AUTH_SESSION = "authsessionkey";// session保持登录信息变量
	public static final String AUTH_ATTR = "loginUser";// request保持登录信息变量
	
}