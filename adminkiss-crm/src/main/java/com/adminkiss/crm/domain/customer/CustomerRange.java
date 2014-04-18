package com.adminkiss.crm.domain.customer;

public class CustomerRange {
	
	public final static short OPTION_CREATE = 0;
	public final static short OPTION_UPDATE = 1;
	public final static short OPTION_DELETE = 2;
	
    private Long id;

    private Short optionType;

    private Long cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getOptionType() {
        return optionType;
    }

    public void setOptionType(Short optionType) {
        this.optionType = optionType;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}