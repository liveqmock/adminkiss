package com.adminkiss.crm.domain.customer;

import java.util.Date;

public class SmsRecord {
	
	public final static short STATUS_DEFAULT = 0;
	public final static short STATUS_SENDING = 1;
	public final static short STATUS_SEND_SUCCESS = 2;
	public final static short STATUS_SEND_FAIL = 3;
	
    private Long id;

    private Long cid;

    private String mobile;

    private Short status; // 状态：0：未发送，1：发送中，2：发送成功，3：发送失败

    private Long createdUid;

    private Date createdTime;

    private Date lastModifiedTime;

    private String content;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getCreatedUid() {
        return createdUid;
    }

    public void setCreatedUid(Long createdUid) {
        this.createdUid = createdUid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}