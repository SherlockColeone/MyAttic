package com.cn.bean;

/**
 * 	���ڷ���ѧ������ʦ������Ա
 * @author Sherlock
 *
 */
public class User {
	//ѧ��
	private Student student;
	//��ʦ
	private Teacher teacher;
	//����Ա
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
