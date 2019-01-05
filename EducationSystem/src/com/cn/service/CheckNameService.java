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
	public String searchByAcademyId(Integer academyId);
	
	/**
	 * 	根据专业的id查询专业的名字
	 * @param majorId 专业id
	 * @return 专业的名字
	 */
	public String searchByMajorId(Integer majorId);
	
	/**
	 * 	根据班级的id查询班级的名字
	 * @param classesId 班级id
	 * @return 班级的名字
	 */
	public String searchByClassesId(Integer classesId);
	
	/**
	 * 	根据学期的id查询学期的名字
	 * @param termid 学期id
	 * @return 学期的名字
	 */
	public String searchByTermid(Integer termId);
	
	/**
	 * 	根据专业课的id查询专业课的名字
	 * @param coursesId 专业课id
	 * @return 专业课的名字
	 */
	public String searchByCoursesId(Integer coursesId);
	
	/**
	 * 	根据社会考试的id查询社会考试的名字
	 * @param cetId 社会考试id
	 * @return 社会考试的名字
	 */
	public String searchByCetId(Integer cetId);
	
	/**
	 * 	根据课室的id查询课室的名字
	 * @param classroomId 课室id
	 * @return 课室的名字
	 */
	public String searchByClassroomId(Integer classroomId);
}
