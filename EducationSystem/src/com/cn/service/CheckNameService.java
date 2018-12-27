package com.cn.service;

/**
 * 	用于把id转换成名字，包括二级学院、专业、班级
 * @author Sherlock
 *
 */
public interface CheckNameService {
	/**
	 * 	根据二级学院的id查询二级学院的名字
	 * @param academyId 二级学院id
	 * @return 二级学院的名字
	 */
	public String searchNameByAcademyId(Integer academyId);
	
	/**
	 * 	根据专业的id查询专业的名字
	 * @param majorId 专业id
	 * @return 专业的名字
	 */
	public String searchNameByMajorId(Integer majorId);
	
	/**
	 * 	根据班级的id查询班级的名字
	 * @param classesId 班级id
	 * @return 班级的名字
	 */
	public String searchNameByClassesId(Integer classesId);
}
