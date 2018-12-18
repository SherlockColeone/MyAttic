package com.cn.bean;
/**
 * øº ‘¿‡
 * @author Sherlock
 *
 */
public class Exam {
	//øº ‘id
	private int id;
	//øº ‘µÿµ„
	private String place;
	//øº ‘ ±º‰
	private String examtime;
	//øº ‘øŒ≥Ãid
	private int coursesid;
	//º‡øº¿œ ¶id
	private int teacherid;
	//øº ‘∞‡º∂id
	private int classesid;
	
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam(int id, String place, String examtime, int coursesid, int teacherid, int classesid) {
		super();
		this.id = id;
		this.place = place;
		this.examtime = examtime;
		this.coursesid = coursesid;
		this.teacherid = teacherid;
		this.classesid = classesid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getExamtime() {
		return examtime;
	}
	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}
	public int getCoursesid() {
		return coursesid;
	}
	public void setCoursesid(int coursesid) {
		this.coursesid = coursesid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getClassesid() {
		return classesid;
	}
	public void setClassesid(int classesid) {
		this.classesid = classesid;
	}	
}
