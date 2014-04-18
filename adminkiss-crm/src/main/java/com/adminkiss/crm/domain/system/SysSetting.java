package com.adminkiss.crm.domain.system;

import java.util.Date;

public class SysSetting {
	
    private Long id;

    private String systemName;

    private Integer customerProtectTime;

    private Integer customerMaxLimit;

    private String seaCustomerTime;

    private Short backupTime;

    private Date lastBackupTime;

    private Date lastRestoreTime;

    private Date createdTime;

    private Date lastModifiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Integer getCustomerProtectTime() {
        return customerProtectTime;
    }

    public void setCustomerProtectTime(Integer customerProtectTime) {
        this.customerProtectTime = customerProtectTime;
    }

    public Integer getCustomerMaxLimit() {
        return customerMaxLimit;
    }

    public void setCustomerMaxLimit(Integer customerMaxLimit) {
        this.customerMaxLimit = customerMaxLimit;
    }

    public String getSeaCustomerTime() {
        return seaCustomerTime;
    }

    public void setSeaCustomerTime(String seaCustomerTime) {
        this.seaCustomerTime = seaCustomerTime;
    }

    public Short getBackupTime() {
        return backupTime;
    }

    public void setBackupTime(Short backupTime) {
        this.backupTime = backupTime;
    }

    public Date getLastBackupTime() {
        return lastBackupTime;
    }

    public void setLastBackupTime(Date lastBackupTime) {
        this.lastBackupTime = lastBackupTime;
    }

    public Date getLastRestoreTime() {
        return lastRestoreTime;
    }

    public void setLastRestoreTime(Date lastRestoreTime) {
        this.lastRestoreTime = lastRestoreTime;
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