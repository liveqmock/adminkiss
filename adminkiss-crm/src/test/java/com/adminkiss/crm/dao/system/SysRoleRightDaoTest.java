package com.adminkiss.crm.dao.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.adminkiss.core.auth.AuthMenu;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SysRoleRightDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private SysRoleRightDao sysRoleRightDao;
	
	@Test
	public void selectMenuByRoleId() {
		try {
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("parentId", 0);
			root.put("roleId", 1);
			List<AuthMenu> list = sysRoleRightDao.selectRightMenuByRole(root);
			for (AuthMenu menu:list) {
				if(menu.getLeaf()==1) {
					root.put("parentId", menu.getId());
					menu.setChild(sysRoleRightDao.selectRightMenuByRole(root));
				}
			}
			Assert.assertNotNull(list);
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}