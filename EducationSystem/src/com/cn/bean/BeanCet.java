package com.cn.bean;

/**
 * 	���ڷ������ʾ��ῼ�Ե�ʵ����
 * @author Sherlock
 *
 */
public class BeanCet {
	//��ῼ������
	private String name;
	//��ῼ��ʱ��
	private String time;
	//��ῼ�Եص�
	private String place;
	//��ῼ�Գɼ�
	private Integer score;
	//�Ƿ�߱��ʸ���/�Ƿ��ѱ�����0�����ǣ�1�����
	private Integer qualification;
	
	public BeanCet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BeanCet(String name, String time, String place, Integer score, Integer qualification) {
		super();
		this.name = name;
		this.time = time;
		this.place = place;
		this.score = score;
		this.qualification = qualification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getQualification() {
		return qualification;
	}
	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "BeanCet [name=" + name + ", time=" + time + ", place=" + place + ", score=" + score + ", qualification="
				+ qualification + "]";
	}
}
