package com.cn.bean;
/**
 * ��ѧ������
 * @author Sherlock
 *
 */
public class Evaluation {
	//id
	private int id;
	//��ʦid
	private int teacherid;
	//����
	private String content;
	
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evaluation(int id, int teacherid, String content) {
		super();
		this.id = id;
		this.teacherid = teacherid;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
