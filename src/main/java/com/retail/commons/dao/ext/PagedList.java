/**  
 * Project Name:retail-commons   
 * File Name:PagedList.java  
 * Package Name:com.retail.common.db.ext  
 * Date:2016年3月23日下午9:52:27  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;

import java.io.Serializable;
import java.util.List;

/**  
 * 描述:<br/>分页对象 <br/>  
 * ClassName: PagedList <br/>  
 * date: 2016年3月23日 下午9:52:27 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class PagedList<E> implements Serializable {

	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;
	private final int DEFAULT_PAGE_SIZE = 10; //默认条数
	private int pageSize;   //每页条数
	private int startRow;  //总条数
	private int endRow;    //结束条数
	private int nowPage; 	//当前页数
	private int nextPage; 	//下一页
	private int prePage ; 	//上一页
	private long totalRow; //总行数
	private int totalPage;	 //总页数
	private List<E> dataList ; 	// 数据集合对象

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	

	public List<E> getDataList() {
		return dataList;
	}

	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}
	
	/**
	 * 该页是否有下一页.
	 * @return
	 */
	public boolean hasNextPage() {
		boolean isExitsNextPage = this.getNowPage() < this.getTotalPage();
		return isExitsNextPage;
	}
	 
	public PagedList(int pageSize,int nowPage, long totalRow) {
		 if (pageSize <= 0) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
        this.setDataList(dataList);
        this.setPrePage(nowPage-1 < 0 ? 0:nowPage-1 );
		this.setNowPage(nowPage);
		this.setPageSize(pageSize);
		this.setTotalRow(totalRow);
		this.setEndRow(nowPage > 0 ? (int)Math.min(pageSize * nowPage, totalRow) : 0);
		this.setStartRow((nowPage - 1) * pageSize);
		int _totalPage = (int)((totalRow % pageSize) > 0 ? ((totalRow / pageSize) + 1) : (totalRow / pageSize));
		this.setTotalPage(Math.min(_totalPage,Integer.MAX_VALUE));
		this.setNextPage(this.getTotalPage() == nowPage?nowPage : nowPage + 1);
	}
	public PagedList(int pageSize,int nowPage, long totalRow, List<E> dataList) {
        if (pageSize <= 0) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
        this.setDataList(dataList);
        this.setPrePage(nowPage-1 < 0 ? 0:nowPage-1 );
  		this.setNowPage(nowPage);
  		this.setPageSize(pageSize);
  		this.setTotalRow(totalRow);
  		this.setEndRow(nowPage > 0 ? (int)Math.min(pageSize * nowPage, totalRow) : 0);
  		this.setStartRow((nowPage - 1) * pageSize);
  		int _totalPage = (int)((totalRow % pageSize) > 0 ? ((totalRow / pageSize) + 1) : (totalRow / pageSize));
  		this.setTotalPage(Math.min(_totalPage,Integer.MAX_VALUE));
  		this.setNextPage(this.getTotalPage() == nowPage?nowPage : nowPage + 1);
	}
	

}
