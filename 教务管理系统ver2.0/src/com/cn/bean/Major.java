package com.cn.bean;
/**
 * רҵ��
 * @author Sherlock
 *
 */
public class Major {
	//רҵid
	private int id;
	//רҵ����
	private String name;
	//����ѧԺid
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
