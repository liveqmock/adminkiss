package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.ContactRecord;

public interface ContactRecordDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(ContactRecord record);

    ContactRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContactRecord record);
    
}