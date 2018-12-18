package com.cn.bean;
/**
 * 班级类
 * @author Sherlock
 *
 */
public class Classes {
	//班级id
	private int id;
	//班级名称
	private String name;
	//专业id
	private int majorid;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes(int id, String name, int majorid) {
		super();
		this.id = id;
		this.name = name;
		this.majorid = majorid;
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
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
}
