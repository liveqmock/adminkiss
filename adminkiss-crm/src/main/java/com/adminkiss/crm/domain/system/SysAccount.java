package com.adminkiss.crm.domain.system;

import java.util.Date;

public class SysAccount {
	
	public final static short STATUS_DEFAULT = 0;
	public final static short STATUS_NORMAL = 1;
	public final static short STATUS_FREEZE = 2;
	public final static short STATUS_DELETE = 3;
	
    private Long id;

    private String username;

    private String password;

    private String salt;

    private String name;

    private Long deptId;

    private Long roleId;

    private Short status;// 账号状态：0：未激活，1：正常，2：冻结，3：删除

    private Integer loginFailure;

    private Date loginTime;

    private Date createdTime;

    private Date lastModifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getLoginFailure() {
        return loginFailure;
    }

    public void setLoginFailure(Integer loginFailure) {
        this.loginFailure = loginFailure;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}