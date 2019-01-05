package com.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Academy;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Classroom;
import com.cn.bean.Courses;
import com.cn.bean.Major;
import com.cn.bean.Term;
import com.cn.dao.AcademyMapper;
import com.cn.dao.CetMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.ClassroomMapper;
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
	@Autowired
	private CetMapper cetMapper;
	@Autowired
	private ClassroomMapper classroomMapper;

	@Override
	public String searchByAcademyId(Integer academyId) {
		//查询二级学院
		Academy academy = academyMapper.selectByPrimaryKey(academyId);
		//获取二级学院的名字
		return academy.getName();
	}

	@Override
	public String searchByMajorId(Integer majorId) {
		Major major = majorMapper.selectByPrimaryKey(majorId);
		return major.getName();
	}

	@Override
	public String searchByClassesId(Integer classesId) {
		Classes classes = classesMapper.selectByPrimaryKey(classesId);
		return classes.getName();
	}

	@Override
	public String searchByTermid(Integer termId) {
		Term term = termMapper.selectByPrimaryKey(termId);
		return term.getTermtime();
	}

	@Override
	public String searchByCoursesId(Integer coursesid) {
		Courses courses = coursesMapper.selectByPrimaryKey(coursesid);
		return courses.getName();
	}

	@Override
	public String searchByCetId(Integer cetId) {
		Cet cet = cetMapper.selectByPrimaryKey(cetId);
		return cet.getCetname();
	}

	@Override
	public String searchByClassroomId(Integer classroomId) {
		Classroom classroom = classroomMapper.selectByPrimaryKey(classroomId);
		return classroom.getName();
	}

}
