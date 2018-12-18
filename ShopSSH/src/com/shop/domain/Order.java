package com.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid; // 订单的id
	private Date  ordertime; // 下订单时间
	private double total; // 总计
	private int state; // 订单的支付状态
	private String address;// 收货人地址
	private String name;// 收货人名字
	private String telephone;// 收货人电话
	private User uid; // 用户的id	
	// 定义订单项
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
