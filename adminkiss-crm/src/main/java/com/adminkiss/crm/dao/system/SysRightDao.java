package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SysRight;

public interface SysRightDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysRight record);

    SysRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRight record);

}