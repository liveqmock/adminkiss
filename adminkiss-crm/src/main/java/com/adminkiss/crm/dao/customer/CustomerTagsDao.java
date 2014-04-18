package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.CustomerTags;

public interface CustomerTagsDao {
	
    int deleteByPrimaryKey(String id);

    int insert(CustomerTags record);

    CustomerTags selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerTags record);
    
}