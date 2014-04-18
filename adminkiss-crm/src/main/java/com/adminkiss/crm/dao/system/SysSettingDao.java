package com.adminkiss.crm.dao.system;

import com.adminkiss.crm.domain.system.SysSetting;

public interface SysSettingDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysSetting record);

    SysSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysSetting record);

}