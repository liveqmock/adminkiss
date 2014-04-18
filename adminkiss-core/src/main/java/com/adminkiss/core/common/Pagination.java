package com.adminkiss.core.common;

import java.util.List;

/**
 * 分页工具类
 */
public class Pagination extends SimplePage {

	private List<?> list;
	
	private Object condition;
	
	private Integer sort;
	
	public Pagination() {
		
	}
	
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}
	
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}
	
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}
	
	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}