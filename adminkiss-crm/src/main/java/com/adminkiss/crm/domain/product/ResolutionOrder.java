package com.adminkiss.crm.domain.product;

import java.util.Date;

public class ResolutionOrder {
	
	public final static short STATUS_DEFAULT = 0;
	public final static short STATUS_DONE = 1;
	public final static short STATUS_UNDO = 2;
	
    private Long id;

    private Long cpid;

    private Date startTime;

    private Date endTime;

    private Short resultStatus;// 0:初始，1:已解决，2：不能解决
    
    private String situation;

    private String resolution;

    private Long createdUid;

    private Date createdTime;

    private Date lastModifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpid() {
        return cpid;
    }

    public void setCpid(Long cpid) {
        this.cpid = cpid;
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

    public Short getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Short resultStatus) {
        this.resultStatus = resultStatus;
    }
    
    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
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
}