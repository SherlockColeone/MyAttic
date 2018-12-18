package com.cn.bean;
/**
 * 学生社会考试记录类
 * @author Sherlock
 *
 */
public class EnrollCet {
	//id
	private int id;
	//社会考试名称id
	private int cetid;
	//考生考号
	private int studentid;
	
	public EnrollCet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnrollCet(int cetid, int studentid) {
		super();
		this.cetid = cetid;
		this.studentid = studentid;
	}
	public EnrollCet(int id, int cetid, int studentid) {
		super();
		this.id = id;
		this.cetid = cetid;
		this.studentid = studentid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCetid() {
		return cetid;
	}

	public void setCetid(int cetid) {
		this.cetid = cetid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
}
