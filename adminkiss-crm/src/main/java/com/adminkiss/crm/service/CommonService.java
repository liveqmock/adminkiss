package com.adminkiss.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.adminkiss.core.auth.AuthMenu;

/**
 * 公共模块接口
 *
 */
public interface CommonService {

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	int login(HttpServletRequest request, String username, String password);
 
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	boolean logout(HttpServletRequest request);

	/**
	 * 根据角色查询菜单信息
	 * @param roleId
	 * @return
	 */
	List<AuthMenu> selectMenuByRoleId(Long roleId);

}
