package com.cn.bean;

/**
 *	 班级类
 * @author Sherlock
 *
 */
public class Classes {
	//班级id
    private Integer id;
    //班级名称
    private String name;
    //专业id
    private Integer majorid;

    public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(Integer id, String name, Integer majorid) {
		super();
		this.id = id;
		this.name = name;
		this.majorid = majorid;
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

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", majorid=" + majorid + "]";
	}
}