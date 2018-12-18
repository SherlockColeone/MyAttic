package com.cn.bean;
/**
 * 二级学院类
 * @author Sherlock
 *
 */
public class Academy {
	//二级学院编号
	private int id;
	//二级学院名称
	private String name;
	
	public Academy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Academy(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
