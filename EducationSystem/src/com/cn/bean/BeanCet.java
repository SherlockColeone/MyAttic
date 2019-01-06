package com.cn.bean;

/**
 * 	用于方便地显示社会考试的实体类
 * @author Sherlock
 *
 */
public class BeanCet {
	//社会考试名称
	private String name;
	//社会考试时间
	private String time;
	//社会考试地点
	private String place;
	//社会考试成绩
	private Integer score;
	//是否具备资格报名/是否已报名。0代表是，1代表否
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
