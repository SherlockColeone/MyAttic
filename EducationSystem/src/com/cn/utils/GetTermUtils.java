package com.cn.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Term;
import com.cn.bean.TermExample;
import com.cn.dao.TermMapper;

/**
 * �����ࣺ��ȡ��ǰѧ�ڻ�������ѧ����Ϣ
 * @author Sherlock
 *
 */
@Service
public class GetTermUtils {	
	@Autowired
	private TermMapper termMapper;
	
	/**
	 * ��ȡ��ǰ��ѧ��id
	 * @return ���ص�ǰѧ��id
	 */
	public static Integer getCurrentTermiId() {
		Date date = new Date();
		//��ȡ��ǰ���
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
		String strYear = dateFormat1.format(date);
		Integer year = new Integer(strYear);
		//��ȡ��ǰ�·�
		DateFormat dateFormat2 = new SimpleDateFormat("MM");
		String strMonth = dateFormat2.format(date);
		Integer term = new Integer(strMonth);
		//�����·��ж�����ѧ��
		if(term==9 || term==10 || term==11 || term==12) { //������ѧ��
			//��ݼ����ַ���1����Ϊѧ��id
			term = new Integer(strYear+"1");
		} 
		else if(term==1||term==2){ //���·�Ϊһ�·ݻ���·�ʱ�����Ҫ��ȥ1��������ѧ��
			year--;
			term = new Integer(year.toString()+"1");
		}
		else if(term==3 || term==4 || term==5 || term==6 || term==7 ||term==8) { //������ѧ�ڣ����Ҫ��ȥ1
			year--;
			//��ݼ����ַ���2����Ϊѧ��id
			term = new Integer(year.toString()+"2");
		} 
		else { //֤�����ں���٣����ؿ�
			return null;
		}
		return term;
	}
	
	/**
	 * ��ȡ���е�ѧ��
	 * @return ѧ�ڼ���
	 */
	public List<Term> getAllTerms() {
		TermExample example = new TermExample();
		return termMapper.selectByExample(example);		
	}
	
	/**
	 * 	��ȡ��ǰ��ѧ�ڣ���XXXX�ꡪ��XXXX�� ��/��ѧ��Ϊ��ʽ
	 * @return ���ص�ǰѧ��
	 */
	public static String getCurrentTerm() {
		Date date = new Date();
		//��ȡ��ǰ���
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
		String strYear = dateFormat1.format(date);
		Integer year = new Integer(strYear);
		//��ȡ��ǰ�·�
		DateFormat dateFormat2 = new SimpleDateFormat("MM");
		String strMonth = dateFormat2.format(date);
		Integer month = new Integer(strMonth);
		String term = "";
		//�����·��ж�����ѧ��
		if(month==9 || month==10 || month==11 || month==12) { //������ѧ��
			year++;
			term = strYear+"��"+year.toString()+" ��ѧ��";
		} 
		else if(month==1||month==2){ //���·�Ϊһ�·ݻ���·�ʱ��������ѧ��
			year--;
			term = year.toString()+"��"+strYear+" ��ѧ��";
		}
		else if(month==3 || month==4 || month==5 || month==6 || month==7 ||month==8) { //���·������·ݣ�������ѧ��
			year--;
			term = year.toString()+"��"+strYear+" ��ѧ��";
		} 
		else { //֤�����ں���٣����ؿ�
			return null;
		}
		return term;
	}
}
