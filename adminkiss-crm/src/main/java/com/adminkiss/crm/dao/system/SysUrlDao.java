package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SysUrl;

public interface SysUrlDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysUrl record);

    SysUrl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUrl record);

}