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
		else if(term==1){ //���·�Ϊһ�·�ʱ�����Ҫ��ȥ1
			year = year-1;
			term = new Integer(year.toString()+"1");
		}
		else if(term==3 || term==4 || term==5 || term==6 || term==7) { //������ѧ�ڣ����Ҫ��ȥ1
			year = year-1;
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
}
