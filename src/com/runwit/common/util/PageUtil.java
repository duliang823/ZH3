package com.runwit.common.util;

public class PageUtil {
	
	private int pageSize; //每页显示条数
	private int recordCount; //记录总数 
	private int currentPage; //当前页
	
	public PageUtil(int pageSize, int recordCount, int currentPage) {
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		setCurrentPage(currentPage);
		//this.currentPage = currentPage;
	}

	public PageUtil(int pageSize, int recordCount) {
		this(pageSize, recordCount, 1);
	}
	
	public int getRecordCount() {
		return recordCount;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * 设置当前页面
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		currentPage = (currentPage < 1) ? 1 : currentPage;
		currentPage = (currentPage > getPageCount()) ? getPageCount() : currentPage;
		this.currentPage = currentPage;
	}
	
	/**
	 * 获得当前页的下一页
	 * @return
	 */
	public int getNextPage(){
		int nextPage = currentPage + 1;
		if(nextPage > getPageCount())
			return getPageCount();
		return nextPage;
	}
	
	/**
	 * 获得当前页的前一页
	 * @return
	 */
	public int getPrevPage(){
		int prevPage = currentPage - 1;
		if(prevPage < 1)
			prevPage = 1;
		return prevPage;
		
	}
	
	/**
	 * 获得页面总数
	 * @return
	 */
	public int getPageCount(){
		int pageCount = recordCount / pageSize;  //总页数
		if(recordCount % pageSize > 0)
			pageCount++;
		return pageCount;
	}
	
	/**
	 * 显示结果的起始索引, 索引从0开始， 包括起始索引
	 * @return
	 */
	public int getFromIndex(){
		int fromIndex = (currentPage-1) * pageSize; //取结果集当中需要显示的数据的开始索引
		fromIndex = (fromIndex < 0) ? 0 : fromIndex;
		return fromIndex;
		
	}
	
	/**
	 * 显示结果的结束索引, 索引从0开始， 不包括结束索引
	 * @return
	 */
	public int getToIndex(){
		int toIndex = currentPage * pageSize; //取结果集当中需要显示的数据的结束索引， 不包括结束索引
		toIndex = (toIndex > recordCount) ? recordCount : toIndex;
		return toIndex;
	}

}
