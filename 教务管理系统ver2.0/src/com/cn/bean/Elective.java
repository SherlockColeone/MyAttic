package com.cn.bean;
/**
 * ѡ�޿γ���
 * @author Sherlock
 *
 */
public class Elective {
	//ѡ�޿�id
	private int id;
	//ѡ�޿�����
	private String name;
	//�Ͽ��ܴΣ�x-y��
	private String week;
	//���ڣ�1-7�ֱ�������һ��������
	private int day;
	//�Ͽν�����x-y(��λ����0x��ʾ����03-04)
	private String time;	
	//�Ͽεص�
	private String place;
	//�ο���ʦ
	private String teacher;	
	//ѧ��id
	private int termid;	
	//�ο���ʦid
	private int teacherid;
	
	public Elective() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Elective(int id, String name, String week, int day, String time, String place, String teacher, int termid,
			int teacherid) {
		super();
		this.id = id;
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.place = place;
		this.teacher = teacher;
		this.termid = termid;
		this.teacherid = teacherid;
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
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getTermid() {
		return termid;
	}
	public void setTermid(int termid) {
		this.termid = termid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	
}
