package com.adminkiss.crm.dao.system;

import java.util.List;
import java.util.Map;
import com.adminkiss.crm.domain.system.SysArea;

public interface SysAreaDao {
	
    int deleteByPrimaryKey(String id);

    int insert(SysArea record);

    SysArea selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysArea record);
    
    List<SysArea> selectByParentCode(Map<String, Object> param);

}