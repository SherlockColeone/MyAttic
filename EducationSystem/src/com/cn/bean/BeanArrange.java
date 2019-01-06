package com.cn.bean;

/**
 * 	用于方便地显示调课的实体类
 * @author Sherlock
 *
 */
public class BeanArrange {
	//课程名称
	private String name;
	//周次
	private String week;
	//日期
	private String date;
	//地点
	private String place;
	//教师名字
	private String teacher;
	//班级名字
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
