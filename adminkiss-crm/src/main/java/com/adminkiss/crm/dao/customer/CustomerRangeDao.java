package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.CustomerRange;

public interface CustomerRangeDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(CustomerRange record);

    CustomerRange selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerRange record);

}