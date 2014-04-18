package com.adminkiss.crm.domain.product;

import java.util.Date;

public class ProblemOrder {
	
	public final static short STATUS_DEFAULT = 0;
	public final static short STATUS_ASSIGN = 1;
	public final static short STATUS_DOING = 2;
	public final static short STATUS_DONE = 3;
	public final static short STATUS_CLOSE = 4;
	
    private Long id;

    private Long cid;

    private String name;

    private String phone;

    private Short urgency;

    private Long authId;

    private Short status;//状态：0：未分配，1：已分配，2：处理中，3：已处理，4：问题关闭

    private Date startTime;

    private Date endTime;

    private Date createdTime;

    private Date lastModifiedTime;

    private String situation;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getUrgency() {
        return urgency;
    }

    public void setUrgency(Short urgency) {
        this.urgency = urgency;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}