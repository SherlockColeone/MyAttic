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
 * 工具类：获取当前学期或者所有学期信息
 * @author Sherlock
 *
 */
@Service
public class GetTermUtils {	
	@Autowired
	private TermMapper termMapper;
	
	/**
	 * 获取当前的学期id
	 * @return 返回当前学期id
	 */
	public static Integer getCurrentTermiId() {
		Date date = new Date();
		//获取当前年份
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
		String strYear = dateFormat1.format(date);
		Integer year = new Integer(strYear);
		//获取当前月份
		DateFormat dateFormat2 = new SimpleDateFormat("MM");
		String strMonth = dateFormat2.format(date);
		Integer term = new Integer(strMonth);
		//根据月份判断上下学期
		if(term==9 || term==10 || term==11 || term==12) { //属于上学期
			//年份加上字符串1，作为学期id
			term = new Integer(strYear+"1");
		} 
		else if(term==1||term==2){ //当月份为一月份或二月份时，年份要减去1，属于上学期
			year--;
			term = new Integer(year.toString()+"1");
		}
		else if(term==3 || term==4 || term==5 || term==6 || term==7 ||term==8) { //属于下学期，年份要减去1
			year--;
			//年份加上字符串2，作为学期id
			term = new Integer(year.toString()+"2");
		} 
		else { //证明属于寒暑假，返回空
			return null;
		}
		return term;
	}
	
	/**
	 * 获取所有的学期
	 * @return 学期集合
	 */
	public List<Term> getAllTerms() {
		TermExample example = new TermExample();
		return termMapper.selectByExample(example);		
	}
	
	/**
	 * 	获取当前的学期，以XXXX年——XXXX年 上/下学期为格式
	 * @return 返回当前学期
	 */
	public static String getCurrentTerm() {
		Date date = new Date();
		//获取当前年份
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy");
		String strYear = dateFormat1.format(date);
		Integer year = new Integer(strYear);
		//获取当前月份
		DateFormat dateFormat2 = new SimpleDateFormat("MM");
		String strMonth = dateFormat2.format(date);
		Integer month = new Integer(strMonth);
		String term = "";
		//根据月份判断上下学期
		if(month==9 || month==10 || month==11 || month==12) { //属于上学期
			year++;
			term = strYear+"—"+year.toString()+" 上学期";
		} 
		else if(month==1||month==2){ //当月份为一月份或二月份时，属于上学期
			year--;
			term = year.toString()+"—"+strYear+" 上学期";
		}
		else if(month==3 || month==4 || month==5 || month==6 || month==7 ||month==8) { //三月份至八月份，属于下学期
			year--;
			term = year.toString()+"—"+strYear+" 下学期";
		} 
		else { //证明属于寒暑假，返回空
			return null;
		}
		return term;
	}
}
