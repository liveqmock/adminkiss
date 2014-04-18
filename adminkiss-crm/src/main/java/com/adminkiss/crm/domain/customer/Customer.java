package com.adminkiss.crm.domain.customer;

import java.util.Date;

public class Customer {
	
	public final static short STORE_DELETE = 0;
	public final static short STORE_RESOURCE = 1;
	public final static short STORE_PUBLIC = 2;
	public final static short STORE_PERSON = 3;
	public final static short STORE_SERVER = 4;
	
	public final static short STATUS_DEFAULT = 0;
	public final static short STATUS_ACTIVE = 1;
	public final static short STATUS_DELETE = 2;
	
    private Long id;

    private Short storeLibrary;// 公司所在库(0:垃圾库;1:资源库;2:公海库;3:个人库;4:服务库)

    private Long repeatId;

    private Short sources;// 客户来源

    private Integer integrity;// 信息完整度（100分制）

    private Short status;// 客户状态(0:初始状态;1:正常状态;2:删除状态)

    private String companyName;

    private String industry;

    private Short companyScope;

    private Short companyType;

    private String telephone;

    private String areaCode;

    private String address;

    private String tags;

    private String website;

    private Long createdUid;

    private Date createdTime;

    private Date lastModifiedTime;

    private String profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getStoreLibrary() {
        return storeLibrary;
    }

    public void setStoreLibrary(Short storeLibrary) {
        this.storeLibrary = storeLibrary;
    }

    public Long getRepeatId() {
        return repeatId;
    }

    public void setRepeatId(Long repeatId) {
        this.repeatId = repeatId;
    }

    public Short getSources() {
        return sources;
    }

    public void setSources(Short sources) {
        this.sources = sources;
    }

    public Integer getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Integer integrity) {
        this.integrity = integrity;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Short getCompanyScope() {
        return companyScope;
    }

    public void setCompanyScope(Short companyScope) {
        this.companyScope = companyScope;
    }

    public Short getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Short companyType) {
        this.companyType = companyType;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}