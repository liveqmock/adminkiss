package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.CustomerContact;

public interface CustomerContactDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(CustomerContact record);

    CustomerContact selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerContact record);
    
}