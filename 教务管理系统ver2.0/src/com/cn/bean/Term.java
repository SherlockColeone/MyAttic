package com.cn.bean;
/**
 * ѧ����
 * @author Sherlock
 *
 */
public class Term {
	//ѧ��id
	private int id;
	//ѧ��ʱ�䣺x��y��-a��b��
	private String termtime;
	
	public Term() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Term(int id, String termtime) {
		super();
		this.id = id;
		this.termtime = termtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTermtime() {
		return termtime;
	}
	public void setTermtime(String termtime) {
		this.termtime = termtime;
	}
}
