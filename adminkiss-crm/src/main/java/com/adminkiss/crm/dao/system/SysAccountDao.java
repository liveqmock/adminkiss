package com.adminkiss.crm.dao.system;

import com.adminkiss.core.auth.AuthLoginUser;
import com.adminkiss.crm.domain.system.SysAccount;

public interface SysAccountDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysAccount record);

    SysAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAccount record);

    /**
     * 根据用户名获取登录账户信息
     * @param username
     * @return
     */
	AuthLoginUser selectByUsername(String username);

}