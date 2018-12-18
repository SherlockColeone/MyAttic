package com.cn.bean;
/**
 * 专业课程类
 * @author Sherlock
 *
 */
public class Courses {
	//专业课id
	private int id;
	//专业课名称
	private String name;
	//上课周次：x-y周
	private String week;
	//星期：1-7分别是星期一至星期日
	private int day;
	//上课节数：x-y(个位数用0x表示，如03-04)
	private String time;
	//上课地点
	private String place;
	//任课老师
	private String teacher;	
	//班级id
	private int classesid;
	//学期id
	private int termid;	
	//任课老师id
	private int teacherid;
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(int id, String name, String week, int day, String time, String place, String teacher, int classesid,
			int termid, int teacherid) {
		super();
		this.id = id;
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.place = place;
		this.teacher = teacher;
		this.classesid = classesid;
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
	public int getClassesid() {
		return classesid;
	}
	public void setClassesid(int classesid) {
		this.classesid = classesid;
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
