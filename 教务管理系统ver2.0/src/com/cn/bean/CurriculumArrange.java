package com.cn.bean;

/**
 * ���ΰ�����
 * @author Sherlock
 *
 */
public class CurriculumArrange {
	//id
	private int id;
	//רҵ��id
	private int coursesid;
	//ѡ�޿�id
	private int electiveid;
	//�����Ͽ��ܴ�
	private String week;
	//�����Ͽ�����
	private int day;
	//�����Ͽν���
	private String time;
	//�Ͽεص�
	private String place;
	//�Ͽΰ༶����Ϊ0��˵����ѡ�޿�
	private int classesid;
	//�ο���ʦ����
	private int teacherid;
	//�����Ƿ���׼��-1��ʾ����׼��0��ʾδ����1��ʾ����׼
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
