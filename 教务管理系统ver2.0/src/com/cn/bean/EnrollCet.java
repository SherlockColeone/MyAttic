package com.cn.bean;
/**
 * ѧ����ῼ�Լ�¼��
 * @author Sherlock
 *
 */
public class EnrollCet {
	//id
	private int id;
	//��ῼ������id
	private int cetid;
	//��������
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
