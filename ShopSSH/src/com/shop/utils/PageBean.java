package com.shop.utils;

import java.util.ArrayList;
import java.util.List;

import com.shop.domain.Product;

/**
 * 专门封装分页信息
 * 
 * @author newuser
 *
 */
public class PageBean<T> {
	// // 使用分页limit查询返回的数据
	// private List<T>productList = new ArrayList<T>();
	//
	// //总页码
	// private int totalPage;
	//
	// // 总记录数(条数)
	// private int totalCount;

	// 当前页
	private int currentPage;

	// 每页显示记录数
	private int currentTootal;

	// 总记录数(条数)
	private int totalCount;

	// 总页码
	private int totalPage;

	// 使用分页limit查询返回的数据
	private List<T> productList = new ArrayList<T>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentTootal() {
		return currentTootal;
	}

	public void setCurrentTootal(int currentTootal) {
		this.currentTootal = currentTootal;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getProductList() {
		return productList;
	}

	public void setProductList(List<T> productList) {
		this.productList = productList;
	}
}
