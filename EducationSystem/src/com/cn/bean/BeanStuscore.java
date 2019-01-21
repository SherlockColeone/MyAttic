package com.cn.bean;

/**
 * 	为学生成绩管理显示成绩信息的实体类
 * @author Sherlock
 *
 */
public class BeanStuscore {
	//学号
	private Integer studentid;
	//班级
	private String classes;
	//姓名
	private String name;
	//平时成绩
	private Integer ordinary;
	//期末成绩
	private Integer endterm;
	//总成绩
	private String score;
	//课程id
	private Integer curriculumId;
	
	public BeanStuscore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeanStuscore(Integer studentid, String classes, String name, Integer ordinary, Integer endterm, String score,
			Integer curriculumId) {
		super();
		this.studentid = studentid;
		this.classes = classes;
		this.name = name;
		this.ordinary = ordinary;
		this.endterm = endterm;
		this.score = score;
		this.curriculumId = curriculumId;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrdinary() {
		return ordinary;
	}

	public void setOrdinary(Integer ordinary) {
		this.ordinary = ordinary;
	}

	public Integer getEndterm() {
		return endterm;
	}

	public void setEndterm(Integer endterm) {
		this.endterm = endterm;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Integer getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}

	@Override
	public String toString() {
		return "BeanStuscore [studentid=" + studentid + ", classes=" + classes + ", name=" + name + ", ordinary="
				+ ordinary + ", endterm=" + endterm + ", score=" + score + ", curriculumId=" + curriculumId + "]";
	}
}
