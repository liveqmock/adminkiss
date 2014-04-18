package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.EmailRecord;

public interface EmailRecordDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(EmailRecord record);

    EmailRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmailRecord record);

}