package com.cn.bean;

/**
 * ��������ʾ��ʦ����ҳ��ʮ�������ʵ����
 * @author Sherlock
 *
 */
public class BeanEvaluation {
	//��ʦ���ţ�Ҳ����Ϊͳ�Ƶ�������
	private Integer teacherid;
	//��һ��
	private Integer first;
	//�ڶ���
	private Integer second;
	//������
	private Integer third;
	//������
	private Integer fourth;
	//������
	private Integer fifth;
	//������
	private Integer sixth;
	//������
	private Integer seventh;
	//�ڰ���
	private Integer eighth;
	//�ھ���
	private Integer nineth;
	//��ʮ��
	private Integer tenth;
	//һ����Ŀ����ѡ��Ľ����ÿ��ѡ��������*�ָ�
	private String item;
	
	public BeanEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	//����ѧ���Ľ�ʦ����
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
	
	//��������
	public BeanEvaluation(Integer teacherid, Integer first, Integer second, Integer third, Integer fourth,
			Integer fifth, Integer sixth, Integer seventh, Integer eighth, Integer nineth, Integer tenth, String item) {
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
		this.item = item;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "BeanEvaluation [teacherid=" + teacherid + ", first=" + first + ", second=" + second + ", third=" + third
				+ ", fourth=" + fourth + ", fifth=" + fifth + ", sixth=" + sixth + ", seventh=" + seventh + ", eighth="
				+ eighth + ", nineth=" + nineth + ", tenth=" + tenth + ", item=" + item + "]";
	}
}
