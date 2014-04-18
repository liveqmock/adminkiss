package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.RepeatOrder;

public interface RepeatOrderDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(RepeatOrder record);

    RepeatOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RepeatOrder record);
    
}