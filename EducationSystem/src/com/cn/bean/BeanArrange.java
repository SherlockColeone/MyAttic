package com.cn.bean;

/**
 * 	���ڷ������ʾ���ε�ʵ����
 * @author Sherlock
 *
 */
public class BeanArrange {
	//רҵ�α��
	private Integer coursesid;
	//ѡ�޿α��
	private Integer electiveid;
	//�γ�����
	private String name;
	//�ܴ�
	private String week;
	//����
	private String date;
	//�ص�
	private String place;
	//��ʦ����
	private String teacher;
	//�༶����
	private String classes;
	//�����Ƿ���׼��-1��ʾ����׼��0��ʾδ����1��ʾ����׼
	private Integer permit;
	
	public BeanArrange() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BeanArrange(Integer coursesid, Integer electiveid, String name, String week, String date, String place,
			String teacher, String classes, Integer permit) {
		super();
		this.coursesid = coursesid;
		this.electiveid = electiveid;
		this.name = name;
		this.week = week;
		this.date = date;
		this.place = place;
		this.teacher = teacher;
		this.classes = classes;
		this.permit = permit;
	}

	public BeanArrange(Integer coursesid, Integer electiveid, String name, String week, String date, String place,
			String teacher, String classes) {
		super();
		this.coursesid = coursesid;
		this.electiveid = electiveid;
		this.name = name;
		this.week = week;
		this.date = date;
		this.place = place;
		this.teacher = teacher;
		this.classes = classes;
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
	
	public Integer getCoursesid() {
		return coursesid;
	}

	public void setCoursesid(Integer coursesid) {
		this.coursesid = coursesid;
	}

	public Integer getElectiveid() {
		return electiveid;
	}

	public void setElectiveid(Integer electiveid) {
		this.electiveid = electiveid;
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
	public Integer getPermit() {
		return permit;
	}
	public void setPermit(Integer permit) {
		this.permit = permit;
	}

	@Override
	public String toString() {
		return "BeanArrange [coursesid=" + coursesid + ", electiveid=" + electiveid + ", name=" + name + ", week="
				+ week + ", date=" + date + ", place=" + place + ", teacher=" + teacher + ", classes=" + classes
				+ ", permit=" + permit + "]";
	}
}
