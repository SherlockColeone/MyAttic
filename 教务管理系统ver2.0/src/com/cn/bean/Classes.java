package com.cn.bean;
/**
 * �༶��
 * @author Sherlock
 *
 */
public class Classes {
	//�༶id
	private int id;
	//�༶����
	private String name;
	//רҵid
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
