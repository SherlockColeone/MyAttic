package com.cn.bean;

/**
 * 	���ڷ������ʾ���ε�ʵ����
 * @author Sherlock
 *
 */
public class BeanArrange {
	//�γ�����
	private String name;
	//�ܴ�
	private String week;
	//����
	private String date;
	//�ص�
	private String place;
	//��ʦ����
	private String teacher;
	//�༶����
	private String classes;
	
	public BeanArrange() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BeanArrange(String name, String week, String date, String place, String teacher, String classes) {
		super();
		this.name = name;
		this.week = week;
		this.date = date;
		this.place = place;
		this.teacher = teacher;
		this.classes = classes;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "BeanArrange [name=" + name + ", week=" + week + ", date=" + date + ", place=" + place + ", teacher="
				+ teacher + ", classes=" + classes + "]";
	}
}
