package com.cn.bean;

/**
 * 接收与显示教师评价页面十道问题的实体类
 * @author Sherlock
 *
 */
public class BeanEvaluation {
	//教师工号
	private Integer teacherid;
	//第一题
	private Integer first;
	//第二题
	private Integer second;
	//第三题
	private Integer third;
	//第四题
	private Integer fourth;
	//第五题
	private Integer fifth;
	//第六题
	private Integer sixth;
	//第七题
	private Integer seventh;
	//第八题
	private Integer eighth;
	//第九题
	private Integer nineth;
	//第十题
	private Integer tenth;
	
	public BeanEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BeanEvaluation(Integer teacherid, Integer first, Integer second, Integer third, Integer fourth,
			Integer fifth, Integer sixth, Integer seventh, Integer eighth, Integer nineth, Integer tenth) {
		super();
		this.teacherid = teacherid;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
		this.seventh = seventh;
		this.eighth = eighth;
		this.nineth = nineth;
		this.tenth = tenth;
	}
	
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getThird() {
		return third;
	}
	public void setThird(Integer third) {
		this.third = third;
	}
	public Integer getFourth() {
		return fourth;
	}
	public void setFourth(Integer fourth) {
		this.fourth = fourth;
	}
	public Integer getFifth() {
		return fifth;
	}
	public void setFifth(Integer fifth) {
		this.fifth = fifth;
	}
	public Integer getSixth() {
		return sixth;
	}
	public void setSixth(Integer sixth) {
		this.sixth = sixth;
	}
	public Integer getSeventh() {
		return seventh;
	}
	public void setSeventh(Integer seventh) {
		this.seventh = seventh;
	}
	public Integer getEighth() {
		return eighth;
	}
	public void setEighth(Integer eighth) {
		this.eighth = eighth;
	}
	public Integer getNineth() {
		return nineth;
	}
	public void setNineth(Integer nineth) {
		this.nineth = nineth;
	}
	public Integer getTenth() {
		return tenth;
	}
	public void setTenth(Integer tenth) {
		this.tenth = tenth;
	}

	@Override
	public String toString() {
		return "BeanEvaluation [teacherid=" + teacherid + ", first=" + first + ", second=" + second + ", third=" + third
				+ ", fourth=" + fourth + ", fifth=" + fifth + ", sixth=" + sixth + ", seventh=" + seventh + ", eighth="
				+ eighth + ", nineth=" + nineth + ", tenth=" + tenth + "]";
	}
}
