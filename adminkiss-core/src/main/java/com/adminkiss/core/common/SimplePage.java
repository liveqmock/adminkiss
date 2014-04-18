package com.adminkiss.core.common;

/**
 * 分页工具类
 */
public class SimplePage {
	
	public static final int DEFAULT_COUNT = 20;
	
	protected int totalCount = 0;// 一共有几条信息
	protected int pageSize = 20;// 一页显示多少条
	protected int pageNo = 1;// 第几页
	
	public SimplePage() {

	}
	
	public SimplePage(int pageNo, int pageSize, int totalCount) {
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setPageNo(pageNo);
		adjustPageNo();
	}

	/**
	 * 保证pageNo从1开始
	 * @param pageNo
	 * @return
	 */
	public static int checkPageNo(Integer pageNo) {
		return (pageNo == null || pageNo < 1) ? 1 : pageNo;
	}
	
	/**
	 * 调整页码，使其不超过最大页数
	 */
	public void adjustPageNo() {
		if (pageNo == 1) {
			return;
		}
		int totalPage = getTotalPage();
		if (pageNo > totalPage) {
			pageNo = totalPage;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}
	
	public int getTotalPage() {
		int totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}
	
	/**
	 * 是否第一页
	 * @return
	 */
	public boolean isFirstPage() {
		return pageNo <= 1;
	}
	
	/**
	 * 是否最后一页
	 * @return
	 */
	public boolean isLastPage() {
		return pageNo >= getTotalPage();
	}
	
	/**
	 * 下一页页码
	 * @return
	 */
	public int getNextPage() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}
	
	public int getPretPage() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}
	
	public void setTotalCount(int totalCount) {
		if (totalCount < 0) {
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
	}
	
	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			this.pageSize = DEFAULT_COUNT;
		} else {
			this.pageSize = pageSize;
		}
	}
	
	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}
}