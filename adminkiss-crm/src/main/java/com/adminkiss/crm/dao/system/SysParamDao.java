package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SysParam;

public interface SysParamDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysParam record);

    SysParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysParam record);

}