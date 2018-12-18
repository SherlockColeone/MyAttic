package com.cn.bean;
/**
 * 社会考试成绩类
 * @author Sherlock
 *
 */
public class GradeCet {
	//id
	private int id;
	//考生考号
	private int studentid;
	//社会考试id
	private int cetid;
	//社会考试时间
	private String cettime;
	//成绩
	private int cetscore;
	//考场id
	private int classroomid;
	//监考老师工号
	private int teacherid;
	
	public GradeCet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeCet(int id, int studentid, int cetid, String cettime, int classroomid, int teacherid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.cetid = cetid;
		this.cettime = cettime;
		this.classroomid = classroomid;
		this.teacherid = teacherid;
	}
	public GradeCet(int id, int studentid, int cetid, String cettime, int cetscore, int classroomid, int teacherid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.cetid = cetid;
		this.cettime = cettime;
		this.cetscore = cetscore;
		this.classroomid = classroomid;
		this.teacherid = teacherid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getCetid() {
		return cetid;
	}
	public void setCetid(int cetid) {
		this.cetid = cetid;
	}
	public String getCettime() {
		return cettime;
	}
	public void setCettime(String cettime) {
		this.cettime = cettime;
	}
	public int getCetscore() {
		return cetscore;
	}
	public void setCetscore(int cetscore) {
		this.cetscore = cetscore;
	}
	public int getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(int classroomid) {
		this.classroomid = classroomid;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	
}
