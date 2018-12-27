package com.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Academy;
import com.cn.bean.Classes;
import com.cn.bean.Major;
import com.cn.dao.AcademyMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.MajorMapper;
import com.cn.service.CheckNameService;

/**
 * 	CheckNameService��ʵ����
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

	@Override
	public String searchNameByAcademyId(Integer academyId) {
		//��ѯ����ѧԺ
		Academy academy = academyMapper.selectByPrimaryKey(academyId);
		//��ȡ����ѧԺ������
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

}
