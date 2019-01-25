package com.cn.bean;

/**
 * 	用于放置学生、教师、管理员
 * @author Sherlock
 *
 */
public class User {
	//学生
	private Student student;
	//教师
	private Teacher teacher;
	//管理员
	private Admin admin;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Student student, Teacher teacher, Admin admin) {
		super();
		this.student = student;
		this.teacher = teacher;
		this.admin = admin;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "User [student=" + student + ", teacher=" + teacher + ", admin=" + admin + "]";
	}
}
