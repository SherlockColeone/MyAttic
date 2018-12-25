package com.cn.bean;

/**
 * 	学生成绩类
 * @author Sherlock
 *
 */
public class Stuscore {
	//id
	private Integer id;
	//学生id
	private Integer studentid;
	//课程名称
	private String coursename;	
	//成绩
	private String score;	
	//学分
	private Integer credit;	
	//绩点
	private Double point;
	//学期id
	private Integer termid;
	//专业课id，若为0，说明该课程不是专业课
	private Integer couresid;
	//选修课id，若为0，说明该课程不是选修课
	private Integer electiveid;

    public Stuscore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stuscore(Integer id, Integer studentid, String coursename, Integer termid, Integer couresid,
			Integer electiveid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.coursename = coursename;
		this.termid = termid;
		this.couresid = couresid;
		this.electiveid = electiveid;
	}

	public Stuscore(Integer id, Integer studentid, String coursename, String score, Integer credit, Double point,
			Integer termid, Integer couresid, Integer electiveid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.coursename = coursename;
		this.score = score;
		this.credit = credit;
		this.point = point;
		this.termid = termid;
		this.couresid = couresid;
		this.electiveid = electiveid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    public Integer getCouresid() {
        return couresid;
    }

    public void setCouresid(Integer couresid) {
        this.couresid = couresid;
    }

    public Integer getElectiveid() {
        return electiveid;
    }

    public void setElectiveid(Integer electiveid) {
        this.electiveid = electiveid;
    }

	@Override
	public String toString() {
		return "Stuscore [id=" + id + ", studentid=" + studentid + ", coursename=" + coursename + ", score=" + score
				+ ", credit=" + credit + ", point=" + point + ", termid=" + termid + ", couresid=" + couresid
				+ ", electiveid=" + electiveid + "]";
	}
}