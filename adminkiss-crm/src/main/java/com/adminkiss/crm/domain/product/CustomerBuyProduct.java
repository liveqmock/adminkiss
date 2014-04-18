package com.adminkiss.crm.domain.product;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerBuyProduct {
	
    private Long id;

    private Long cid;

    private Long pid;

    private Integer discount;

    private BigDecimal cheap;

    private BigDecimal price;

    private Short payStatus;

    private Date warrantyStartTime;

    private Date warrantyEndTime;

    private Integer warrantyCount;

    private Long authId;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getCheap() {
        return cheap;
    }

    public void setCheap(BigDecimal cheap) {
        this.cheap = cheap;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public Date getWarrantyStartTime() {
        return warrantyStartTime;
    }

    public void setWarrantyStartTime(Date warrantyStartTime) {
        this.warrantyStartTime = warrantyStartTime;
    }

    public Date getWarrantyEndTime() {
        return warrantyEndTime;
    }

    public void setWarrantyEndTime(Date warrantyEndTime) {
        this.warrantyEndTime = warrantyEndTime;
    }

    public Integer getWarrantyCount() {
        return warrantyCount;
    }

    public void setWarrantyCount(Integer warrantyCount) {
        this.warrantyCount = warrantyCount;
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
}