package com.adminkiss.crm.data;

import java.util.Date;

import com.adminkiss.core.auth.AuthLoginUser;
import com.adminkiss.core.auth.AuthUtils;
import com.adminkiss.crm.domain.system.SysAccount;

public class SysAccountData {

	public static SysAccount randomData(Long deptId, Long roleId) {
		SysAccount sa = new SysAccount();
		sa.setUsername("adminTest");
		AuthLoginUser authLoginUser = new AuthLoginUser();
		authLoginUser.setPlainPassword("123456");
		AuthUtils.entryptPassword(authLoginUser);
		sa.setPassword(authLoginUser.getPassword());
		sa.setSalt(authLoginUser.getSalt());
		sa.setName("Test");
		sa.setDeptId(deptId);
		sa.setRoleId(roleId);
		sa.setLoginFailure(0);
		sa.setLoginTime(new Date());
		sa.setStatus(SysAccount.STATUS_NORMAL);
		return sa;
	}

}