package com.adminkiss.crm.domain.system;

import java.util.Date;

public class SysArea {
	
	public final static short STATUS_NOT_HOT = 0;
	public final static short STATUS_HOT = 1;
	
    private String id;

    private String name;

    private String displayName;

    private Short hotStatus;// 是否热门

    private Integer sort;

    private Date createdTime;

    private Date lastModifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Short getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(Short hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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