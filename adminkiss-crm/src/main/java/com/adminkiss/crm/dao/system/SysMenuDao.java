package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SysMenu;

public interface SysMenuDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

}