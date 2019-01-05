package com.cn.bean;

/**
 * ��ῼ�Գɼ���
 * @author Sherlock
 *
 */
public class Gradecet {
	//id
	private Integer id;
	//��������
	private Integer studentid;
	//��ῼ��id
    private Integer cetid;
	//��ῼ��ʱ��
	private String cettime;
	//�ɼ�
	private Integer cetscore;
	//����id
	private Integer classroomid;
	//�࿼��ʦ����
	private Integer teacherid;

    public Gradecet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gradecet(Integer studentid, Integer cetid) {
		super();
		this.studentid = studentid;
		this.cetid = cetid;
	}

	public Gradecet(Integer id, Integer studentid, Integer cetid, String cettime, Integer classroomid,
			Integer teacherid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.cetid = cetid;
		this.cettime = cettime;
		this.classroomid = classroomid;
		this.teacherid = teacherid;
	}

	public Gradecet(Integer id, Integer studentid, Integer cetid, String cettime, Integer cetscore, Integer classroomid,
			Integer teacherid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.cetid = cetid;
		this.cettime = cettime;
		this.cetscore = cetscore;
		this.classroomid = classroomid;
		this.teacherid = teacherid;
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

    public Integer getCetid() {
        return cetid;
    }

    public void setCetid(Integer cetid) {
        this.cetid = cetid;
    }

    public String getCettime() {
        return cettime;
    }

    public void setCettime(String cettime) {
        this.cettime = cettime == null ? null : cettime.trim();
    }

    public Integer getCetscore() {
        return cetscore;
    }

    public void setCetscore(Integer cetscore) {
        this.cetscore = cetscore;
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

	@Override
	public String toString() {
		return "Gradecet [id=" + id + ", studentid=" + studentid + ", cetid=" + cetid + ", cettime=" + cettime
				+ ", cetscore=" + cetscore + ", classroomid=" + classroomid + ", teacherid=" + teacherid + "]";
	}
}