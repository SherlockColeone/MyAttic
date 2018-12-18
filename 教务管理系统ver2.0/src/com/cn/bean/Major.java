package com.cn.bean;
/**
 * 专业类
 * @author Sherlock
 *
 */
public class Major {
	//专业id
	private int id;
	//专业名称
	private String name;
	//二级学院id
	private int academyid;
	
	public Major() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Major(int id, String name, int academyid) {
		super();
		this.id = id;
		this.name = name;
		this.academyid = academyid;
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
	public int getAcademyid() {
		return academyid;
	}
	public void setAcademyid(int academyid) {
		this.academyid = academyid;
	}
}
