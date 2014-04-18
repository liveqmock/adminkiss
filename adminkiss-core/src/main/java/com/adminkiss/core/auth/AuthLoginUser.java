package com.adminkiss.core.auth;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 登录用户信息
 */
public class AuthLoginUser {

	private Long id;//用户id
	private Long deptId;//部门id
	private Long roleId;//角色id
	private String username;//用户名
	private String name;//姓名
	private String plainPassword;//明文密码
	private String password;//加密密码
	private String salt;//加密密码散列
	private Short status;//用户状态
	private Integer loginFailureCount;//登录错误次数，3次过后锁定账号
	private Date lastLoginTime;//最后登录时间
	private Set<String> right = new HashSet<String>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getRight() {
		return right;
	}

	public void setRight(Set<String> right) {
		this.right = right;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
