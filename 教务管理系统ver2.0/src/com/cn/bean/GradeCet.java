package com.cn.bean;
/**
 * ��ῼ�Գɼ���
 * @author Sherlock
 *
 */
public class GradeCet {
	//id
	private int id;
	//��������
	private int studentid;
	//��ῼ��id
	private int cetid;
	//��ῼ��ʱ��
	private String cettime;
	//�ɼ�
	private int cetscore;
	//����id
	private int classroomid;
	//�࿼��ʦ����
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
