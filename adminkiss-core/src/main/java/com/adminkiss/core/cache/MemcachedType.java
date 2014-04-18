package com.adminkiss.core.cache;

/**
 * 统一定义Memcached中存储的各种对象的Key前缀和超时时间.
 *
 */
public enum MemcachedType {

	AREA("area:", 0),// 地区信息
	AREAALL("areaall:", 0),// 地区信息（全称）
	AREA_TREE("areatree:", 0), 
	SUM_MENU_BY_ROLEID("menu:role:", 0);// 地区信息(根据父code取得子code)
	
	private String prefix;
	
	private int expiredTime;

	MemcachedType(String prefix, int expiredTime) {
		this.prefix = prefix;
		this.expiredTime = expiredTime;
	}

	public String getPrefix() {
		return prefix;
	}

	public int getExpiredTime() {
		return expiredTime;
	}

}