package com.cn.bean;
/**
 * 学生成绩类
 * @author Sherlock
 *
 */
public class StuScore {
	//id
	private int id;
	//学生id
	private int studentid;
	//课程名称
	private String coursesname;	
	//成绩
	private String score;	
	//学分
	private int credit;	
	//绩点
	private double point;
	//学期id
	private int termid;
	//专业课id，若为0，说明该课程不是专业课
	private int coursesid;
	//选修课id，若为0，说明该课程不是选修课
	private int electiveid;
	
	public StuScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StuScore(int id, int studentid, String coursesname, String score, int credit, double point, int termid,
			int coursesid, int electiveid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.coursesname = coursesname;
		this.score = score;
		this.credit = credit;
		this.point = point;
		this.termid = termid;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
	}
	public StuScore(int id, int studentid, String coursesname, int termid, int coursesid, int electiveid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.coursesname = coursesname;
		this.termid = termid;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
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
	public String getCoursesname() {
		return coursesname;
	}
	public void setCoursesname(String coursesname) {
		this.coursesname = coursesname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public int getTermid() {
		return termid;
	}
	public void setTermid(int termid) {
		this.termid = termid;
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
}
