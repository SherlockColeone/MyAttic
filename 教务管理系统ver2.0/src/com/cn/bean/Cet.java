package com.cn.bean;
/**
 * ��ῼ����
 * @author Sherlock
 *
 */
public class Cet {
	//��ῼ��id
	private int id;
	//��ῼ������
	private String cetname;	
	//��ῼ��ʱ��
	private String cettime;
	//ѧ��id
	private int termid;
	
	public Cet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cet(int id, String cetname, String cettime) {
		super();
		this.id = id;
		this.cetname = cetname;
		this.cettime = cettime;
	}
	public Cet(int id, String cetname, String cettime, int termid) {
		super();
		this.id = id;
		this.cetname = cetname;
		this.cettime = cettime;
		this.termid = termid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCetname() {
		return cetname;
	}
	public void setCetname(String cetname) {
		this.cetname = cetname;
	}
	public String getCettime() {
		return cettime;
	}
	public void setCettime(String cettime) {
		this.cettime = cettime;
	}
	public int getTermid() {
		return termid;
	}
	public void setTermid(int termid) {
		this.termid = termid;
	}	
}
