package com.adminkiss.crm.data;

import com.adminkiss.crm.domain.system.SysArea;

public class SysAreaData {

	public static SysArea randomData() {
		SysArea sa = new SysArea();
		sa.setId("X002B001C001");
		sa.setDisplayName("中国浙江省杭州市");
		sa.setHotStatus(SysArea.STATUS_HOT);
		sa.setName("杭州市");
		sa.setSort(1);
		return sa;
	}

}