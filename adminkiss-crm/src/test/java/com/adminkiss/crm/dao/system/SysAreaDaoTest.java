package com.adminkiss.crm.dao.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.adminkiss.crm.data.SysAreaData;
import com.adminkiss.crm.domain.system.SysArea;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SysAreaDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private SysAreaDao sysAreaDao;

	private SysArea sa;

	@Test
	public void selectByPrimaryKey() {
		SysArea sysArea = sysAreaDao.selectByPrimaryKey(sa.getId());
		assertNotNull("Data not found", sysArea);
	}

	@Test
	public void updateByPrimaryKeySelective() {
		SysArea sysArea = new SysArea();
		sysArea.setId(sa.getId());
		sysArea.setName("test");
		Integer result = sysAreaDao.updateByPrimaryKeySelective(sysArea);
		assertNotNull("update fail", result);
		sa = sysAreaDao.selectByPrimaryKey(sa.getId());
		assertEquals(sysArea.getName(), sa.getName());
	}
	
	@Test
	public void selectByParentCode() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", 0);
		param.put("parentCode", "X");
		List<SysArea> list= sysAreaDao.selectByParentCode(param);
		assertEquals(list.size(), 1);
	}

	@Before
	public void init() {
		sa = SysAreaData.randomData();
		sysAreaDao.insert(sa);
	}

	@After
	public void destroy() {
		sysAreaDao.deleteByPrimaryKey(sa.getId());
	}

}