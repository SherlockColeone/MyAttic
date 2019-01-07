package com.cn.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 工具类：获取当前的学期
 * @author Sherlock
 *
 */
@Service
public class GetCurrentTermUtils {	
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
		else if(term==1){ //当月份为一月份时，年份要减去1
			year = year-1;
			term = new Integer(year.toString()+"1");
		}
		else if(term==3 || term==4 || term==5 || term==6 || term==7) { //属于下学期，年份要减去1
			year = year-1;
			//年份加上字符串2，作为学期id
			term = new Integer(year.toString()+"2");
		} 
		else { //证明属于寒暑假，返回空
			return null;
		}
		return term;
	}
}
