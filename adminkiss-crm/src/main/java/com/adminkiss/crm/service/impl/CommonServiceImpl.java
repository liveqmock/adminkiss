package com.adminkiss.crm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminkiss.core.auth.AuthConst;
import com.adminkiss.core.auth.AuthLoginUser;
import com.adminkiss.core.auth.AuthMenu;
import com.adminkiss.core.auth.AuthUtils;
import com.adminkiss.core.auth.SessionFactory;
import com.adminkiss.crm.dao.system.SysAccountDao;
import com.adminkiss.crm.dao.system.SysRoleRightDao;
import com.adminkiss.crm.domain.system.SysAccount;
import com.adminkiss.crm.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private SysAccountDao sysAccountDao;
	
	@Autowired
	private SysRoleRightDao sysRoleRightDao;
	
	@Override
	public int login(HttpServletRequest request, String username, String password) {
		String context = request.getContextPath();
		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(password)) {
			AuthLoginUser user = sysAccountDao.selectByUsername(username);
			if (user != null) {
				boolean canUsed = false;
				if (user.getStatus() == SysAccount.STATUS_NORMAL) {
					canUsed = true;
				} else if (user.getStatus() == SysAccount.STATUS_FREEZE) {
					// 账号冻结，登录出现三次错误后，锁定账号，30分钟后解封
					DateTime now = new DateTime();
					DateTime lock = new DateTime(user.getLastLoginTime());
					int minutes = Minutes.minutesBetween(lock, now).getMinutes();
					if (minutes > 30) {
						SysAccount updateUser = new SysAccount();
						updateUser.setId(user.getId());
						updateUser.setStatus(SysAccount.STATUS_NORMAL);
						updateUser.setLoginFailure(0);
						Integer result = sysAccountDao.updateByPrimaryKeySelective(updateUser);
						if (result > 0) {
							canUsed = true;
						}
					}
					if(!canUsed) {
						return AuthConst.LOGIN_ACCOUNT_FREEZE;
					}
				}
				if (canUsed) {
					user.setPlainPassword(password);
					if (AuthUtils.validatePassword(user)) {
						user.setRight(buildRight(context, user.getRoleId()));
						// 判断账户是否已经登录（已经登录踢出已登录账户）
						if (SessionFactory.getInstance().isLogin(
								request.getSession(), user.getId())) {
							SessionFactory.getInstance().removeLogin(
									request.getSession());
						}
						// 设置session
						AuthUtils.setAccountToSession(request, user);
						SysAccount updateUser = new SysAccount();
						updateUser.setId(user.getId());
						updateUser.setLoginFailure(0);
						updateUser.setLoginTime(new Date());
						sysAccountDao.updateByPrimaryKeySelective(updateUser);
						return AuthConst.LOGIN_SUCCESS;
					} else {
						SysAccount updateUser = new SysAccount();
						updateUser.setId(user.getId());
						if (user.getLoginFailureCount() > 3) {
							updateUser.setStatus(SysAccount.STATUS_FREEZE);
						}
						updateUser.setLoginFailure((user.getLoginFailureCount() + 1));
						sysAccountDao.updateByPrimaryKeySelective(updateUser);
						return AuthConst.LOGIN_FAILURE;
					}
				} else {
					return AuthConst.LOGIN_ACCOUNT_UNUSED;
				}
			} else {
				return AuthConst.LOGIN_USER_NOT_FOUND;
			}
		} else {
			return AuthConst.LOGIN_USERNAME_OR_PASSWORD_EMPTY;
		}
	}
	
	private Set<String> buildRight(String content, Long roleId) {
		List<String> rights = sysRoleRightDao.selectRightUrlByRole(roleId);
		return new HashSet<String>(rights);
	}

	@Override
	public boolean logout(HttpServletRequest request) {
		AuthUtils.removeAccountFromSession(request);
		return true;
	}

	@Override
	public List<AuthMenu> selectMenuByRoleId(Long roleId) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("parentId", 0);
		root.put("roleId", roleId);
		List<AuthMenu> list = sysRoleRightDao.selectRightMenuByRole(root);
		for (AuthMenu menu:list) {
			if(menu.getLeaf()==1) {
				root.put("parentId", menu.getId());
				menu.setChild(sysRoleRightDao.selectRightMenuByRole(root));
			}
		}
		return list;
	}

}
