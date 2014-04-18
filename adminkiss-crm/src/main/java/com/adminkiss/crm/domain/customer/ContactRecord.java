package com.adminkiss.crm.domain.customer;

import java.util.Date;

public class ContactRecord {
	
	public final static short CONTACT_TYPE_IN = 1;
	public final static short CONTACT_TYPE_OUT = 2;
	
    private Long id;

    private Long cid;

    private Long ccid;

    private Short contactType;// 通话类型（呼入，呼出）

    private Short contactStatus;// 联系状态（有进展，无进展，无人接听，停机，关机）

    private String attachment;// 通话录音附件

    private Long authId;
    
    private String content;

    private Date createdTime;

    private Date lastModifiedTime;

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

    public Long getCcid() {
        return ccid;
    }

    public void setCcid(Long ccid) {
        this.ccid = ccid;
    }

    public Short getContactType() {
        return contactType;
    }

    public void setContactType(Short contactType) {
        this.contactType = contactType;
    }

    public Short getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(Short contactStatus) {
        this.contactStatus = contactStatus;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
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