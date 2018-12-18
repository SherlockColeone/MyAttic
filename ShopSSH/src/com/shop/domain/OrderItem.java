package com.shop.domain;

public class OrderItem {
	private String itemid; //订单项id
	private int count;// 数量
	private double subtotal;  // 小计
	private Product pid;  // 商品id
	private Order oid; // 订单的id  一个订单项属于哪个订单的
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getPid() {
		return pid;
	}
	public void setPid(Product pid) {
		this.pid = pid;
	}
	public Order getOid() {
		return oid;
	}
	public void setOid(Order oid) {
		this.oid = oid;
	}
	
}
