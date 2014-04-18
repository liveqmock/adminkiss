package com.adminkiss.crm.dao.system;

import java.util.List;
import java.util.Map;

import com.adminkiss.core.auth.AuthMenu;
import com.adminkiss.crm.domain.system.SysRoleRight;

public interface SysRoleRightDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleRight record);

    SysRoleRight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleRight record);

    /**
     * 获取角色权限信息
     * @param roleId
     * @return
     */
	List<String> selectRightUrlByRole(Long roleId);

	/**
	 * 根据角色获取菜单
	 * @param roleId
	 * @return
	 */
	List<AuthMenu> selectRightMenuByRole(Map<String, Object> root);

}