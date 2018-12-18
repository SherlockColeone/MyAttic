package com.cn.bean;
/**
 * 选课报名记录类
 * @author Sherlock
 *
 */
public class TempElective {
	//id
	private int id;
	//选修课id
	private int electiveid;
	//学号
	private int studentid;
	
	public TempElective() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TempElective(int id, int electiveid, int studentid) {
		super();
		this.id = id;
		this.electiveid = electiveid;
		this.studentid = studentid;
	}
	public TempElective(int electiveid, int studentid) {
		super();
		this.electiveid = electiveid;
		this.studentid = studentid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getElectiveid() {
		return electiveid;
	}
	public void setElectiveid(int electiveid) {
		this.electiveid = electiveid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
}
