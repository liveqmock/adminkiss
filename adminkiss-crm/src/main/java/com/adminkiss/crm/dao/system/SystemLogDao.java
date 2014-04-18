package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SystemLog;

public interface SystemLogDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SystemLog record);

    SystemLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemLog record);

}