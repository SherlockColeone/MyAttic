package com.cn.bean;

/**
 * 	专业类
 * @author Sherlock
 *
 */
public class Major {
	//专业id
	private Integer id;
	//专业名称
	private String name;
	//二级学院id
	private Integer academyid;

    public Major() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Major(Integer id, String name, Integer academyid) {
		super();
		this.id = id;
		this.name = name;
		this.academyid = academyid;
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }

	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", academyid=" + academyid + "]";
	}
}