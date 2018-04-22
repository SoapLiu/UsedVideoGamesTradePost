package com.tradepost.entity;

import java.util.List;

public class Page {

	private int currentPage;
	private int pageSize;
	private int count;
	private int totalPage;
	private List<Article> list;
	
	public Page() {
	}
	
	public Page(int currentPage, int pageSize, int count, int totalPage, List<Article> list) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.totalPage = totalPage;
		this.list = list;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
