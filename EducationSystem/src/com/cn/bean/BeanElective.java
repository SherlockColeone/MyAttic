package com.cn.bean;

/**
 * ���ڹ���Ա����ѧ��ѡ�ν����ʵ����
 * @author Sherlock
 *
 */
public class BeanElective {
	//�Ƿ������ѡ�Σ�0����δ��ӣ�1���������
	private Integer isInserted;
	//ѡ�޿α��
	private Integer id;
	//ѡ�޿�����
	private String name;
	//����ʱ��
	private String week;
	//�γ̽�ʦ���
	private Integer teacherid;
	//�γ̽�ʦ����
	private String teacher;
	//�Ͽ�ʱ��
	private String time;
	//�Ͽεص�
	private String place;
	//�γ�����
	private Integer number;
	
	public BeanElective() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BeanElective(Integer isInserted, Integer id, String name, String week, Integer teacherid, String teacher,
			String time, String place, Integer number) {
		super();
		this.isInserted = isInserted;
		this.id = id;
		this.name = name;
		this.week = week;
		this.teacherid = teacherid;
		this.teacher = teacher;
		this.time = time;
		this.place = place;
		this.number = number;
	}
	
	public Integer getIsInserted() {
		return isInserted;
	}
	public void setIsInserted(Integer isInserted) {
		this.isInserted = isInserted;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "BeanElective [isInserted=" + isInserted + ", id=" + id + ", name=" + name + ", week=" + week
				+ ", teacherid=" + teacherid + ", teacher=" + teacher + ", time=" + time + ", place=" + place
				+ ", number=" + number + "]";
	}	
}
