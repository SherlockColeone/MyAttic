package com.cn.bean;
/**
 * ѡ�α�����¼��
 * @author Sherlock
 *
 */
public class TempElective {
	//id
	private int id;
	//ѡ�޿�id
	private int electiveid;
	//ѧ��
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
