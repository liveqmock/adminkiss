package com.adminkiss.crm.domain.customer;

import java.util.Date;

public class RepeatOrder {
	
	public final static short STATUS_DEFAULT = 0;
	public final static short STATUS_CHECKING = 1;
	public final static short STATUS_CHECK_DONE = 2;
	
    private Long id;

    private String repeatIds;

    private Short status;

    private Long createdUid;

    private Long checkUid;

    private Long repeatId;

    private Date createdTime;

    private Date lastModifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepeatIds() {
        return repeatIds;
    }

    public void setRepeatIds(String repeatIds) {
        this.repeatIds = repeatIds;
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

    public Long getCheckUid() {
        return checkUid;
    }

    public void setCheckUid(Long checkUid) {
        this.checkUid = checkUid;
    }

    public Long getRepeatId() {
        return repeatId;
    }

    public void setRepeatId(Long repeatId) {
        this.repeatId = repeatId;
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