package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.AuthCustomer;

public interface AuthCustomerDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(AuthCustomer record);

    AuthCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthCustomer record);
    
}