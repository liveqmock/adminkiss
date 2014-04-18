package com.adminkiss.crm.dao.customer;

import com.adminkiss.crm.domain.customer.SmsRecord;

public interface SmsRecordDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SmsRecord record);

    SmsRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsRecord record);

}