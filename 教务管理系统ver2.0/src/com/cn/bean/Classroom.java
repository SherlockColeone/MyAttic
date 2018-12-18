package com.cn.bean;
/**
 * ¿ÎÊÒÀà
 * @author Sherlock
 *
 */
public class Classroom {
	//¿ÎÊÒid
	private int id;
	//¿ÎÊÒµØµã
	private String name;
	//ÈİÄÉÈËÊı
	private int number;
	
	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classroom(int id, String name, int number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}	
}
