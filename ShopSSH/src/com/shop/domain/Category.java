package com.shop.domain;

/**
 * 商品分类
 * 
 * @author Sherlock
 *
 */
public class Category {
	private int cid;
	private String cname;

	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
}
