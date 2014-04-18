package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SysParamItem;

public interface SysParamItemDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysParamItem record);

    SysParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysParamItem record);

}