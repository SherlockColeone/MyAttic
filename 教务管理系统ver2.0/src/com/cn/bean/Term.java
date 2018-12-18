package com.cn.bean;
/**
 * 学期类
 * @author Sherlock
 *
 */
public class Term {
	//学期id
	private int id;
	//学期时间：x年y月-a年b月
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
