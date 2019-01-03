package com.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Academy;
import com.cn.bean.Classes;
import com.cn.bean.Courses;
import com.cn.bean.Major;
import com.cn.bean.Term;
import com.cn.dao.AcademyMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.MajorMapper;
import com.cn.dao.TermMapper;
import com.cn.service.CheckNameService;

/**
 * 	CheckNameService的实现类
 * @author Sherlock
 *
 */

@Service
public class CheckNameServiceImpl implements CheckNameService {
	@Autowired
	private AcademyMapper academyMapper;
	@Autowired
	private MajorMapper majorMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private TermMapper termMapper;
	@Autowired
	private CoursesMapper coursesMapper;

	@Override
	public String searchNameByAcademyId(Integer academyId) {
		//查询二级学院
		Academy academy = academyMapper.selectByPrimaryKey(academyId);
		//获取二级学院的名字
		return academy.getName();
	}

	@Override
	public String searchNameByMajorId(Integer majorId) {
		Major major = majorMapper.selectByPrimaryKey(majorId);
		return major.getName();
	}

	@Override
	public String searchNameByClassesId(Integer classesId) {
		Classes classes = classesMapper.selectByPrimaryKey(classesId);
		return classes.getName();
	}

	@Override
	public String searchNameByTermid(Integer termId) {
		Term term = termMapper.selectByPrimaryKey(termId);
		return term.getTermtime();
	}

	@Override
	public String searchNameByCoursesId(Integer coursesid) {
		Courses courses = coursesMapper.selectByPrimaryKey(coursesid);
		return courses.getName();
	}

}
