package com.adminkiss.crm.dao.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.adminkiss.crm.data.SysAccountData;
import com.adminkiss.crm.domain.system.SysAccount;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SysAccountDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private SysAccountDao sysAccountDao;

	private SysAccount sa;

	@Test
	public void selectByPrimaryKey() {
		SysAccount sysAccount = sysAccountDao.selectByPrimaryKey(sa.getId());
		assertNotNull("Data not found", sysAccount);
	}

	@Test
	public void updateByPrimaryKeySelective() {
		SysAccount sysAccount = new SysAccount();
		sysAccount.setId(sa.getId());
		sysAccount.setName("test");
		Integer result = sysAccountDao.updateByPrimaryKeySelective(sysAccount);
		assertNotNull("update fail", result);
		sa = sysAccountDao.selectByPrimaryKey(sa.getId());
		assertEquals(sysAccount.getName(), sa.getName());
	}


	@Before
	public void init() {
		
		sa = SysAccountData.randomData(1L, 1L);
		sysAccountDao.insert(sa);
	}

	@After
	public void destroy() {
		sysAccountDao.deleteByPrimaryKey(sa.getId());
	}

}