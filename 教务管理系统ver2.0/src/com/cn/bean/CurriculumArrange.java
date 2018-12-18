package com.cn.bean;

/**
 * 调课安排类
 * @author Sherlock
 *
 */
public class CurriculumArrange {
	//id
	private int id;
	//专业课id
	private int coursesid;
	//选修课id
	private int electiveid;
	//调课上课周次
	private String week;
	//调课上课星期
	private int day;
	//调课上课节数
	private String time;
	//上课地点
	private String place;
	//上课班级，若为0，说明是选修课
	private int classesid;
	//任课老师工号
	private int teacherid;
	//教务处是否批准，-1表示不批准、0表示未处理、1表示已批准
	private int permit;
	
	public CurriculumArrange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurriculumArrange(int id, int coursesid, int electiveid, String week, int day, String time, String place,
			int classesid, int teacherid, int permit) {
		super();
		this.id = id;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
		this.week = week;
		this.day = day;
		this.time = time;
		this.place = place;
		this.classesid = classesid;
		this.teacherid = teacherid;
		this.permit = permit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoursesid() {
		return coursesid;
	}
	public void setCoursesid(int coursesid) {
		this.coursesid = coursesid;
	}
	public int getElectiveid() {
		return electiveid;
	}
	public void setElectiveid(int electiveid) {
		this.electiveid = electiveid;
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
	public int getClassesid() {
		return classesid;
	}
	public void setClassesid(int classesid) {
		this.classesid = classesid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getPermit() {
		return permit;
	}
	public void setPermit(int permit) {
		this.permit = permit;
	}
}
