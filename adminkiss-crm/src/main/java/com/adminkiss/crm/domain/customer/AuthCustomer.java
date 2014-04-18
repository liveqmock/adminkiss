package com.adminkiss.crm.domain.customer;

import java.util.Date;

public class AuthCustomer {
	
	public final static short IMPORTANCE_FALSE = 0;
	public final static short IMPORTANCE_TRUE = 1;
	
	public final static short STATUS_NOT_ACTIVE = 0;
	public final static short STATUS_ACTIVE = 1;
	
    private Long id;

    private Long cid;

    private Long authId;

    private Long recordId;

    private Date lastContactTime;

    private Long nextContactId;

    private Date nextContactTime;

    private Integer contactCount;

    private Short star;// 客户成熟度（1-5星）

    private Short importance;// 是否重要

    private Short ctype;// 客户类型

    private Short status;// 关系状态

    private Date createdTime;

    private Date lastModifieldTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(Date lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public Long getNextContactId() {
        return nextContactId;
    }

    public void setNextContactId(Long nextContactId) {
        this.nextContactId = nextContactId;
    }

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    public Integer getContactCount() {
        return contactCount;
    }

    public void setContactCount(Integer contactCount) {
        this.contactCount = contactCount;
    }

    public Short getStar() {
        return star;
    }

    public void setStar(Short star) {
        this.star = star;
    }

    public Short getImportance() {
        return importance;
    }

    public void setImportance(Short importance) {
        this.importance = importance;
    }

    public Short getCtype() {
        return ctype;
    }

    public void setCtype(Short ctype) {
        this.ctype = ctype;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifieldTime() {
        return lastModifieldTime;
    }

    public void setLastModifieldTime(Date lastModifieldTime) {
        this.lastModifieldTime = lastModifieldTime;
    }
}