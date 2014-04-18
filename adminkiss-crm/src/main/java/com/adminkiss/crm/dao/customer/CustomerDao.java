package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.Customer;

public interface CustomerDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer record);

}