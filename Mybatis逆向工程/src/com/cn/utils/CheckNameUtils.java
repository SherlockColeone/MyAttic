package com.cn.utils;

/**
 * 	用于把id转换成名字，包括所有的实体类
 * @author Sherlock
 *
 */
public interface CheckNameUtils {	
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
	
	/**
	 *	 把星期的数字转化成星期几，若返回空，则说明数字已超出1-7
	 * @param day 星期数字
	 * @return 返回星期几
	 */
	public String transformDay(Integer day);
	
	/**
	 * 	根据教师工号查询教师的名字
	 * @param teacherId 教师id
	 * @return 教师的名字
	 */
	public String searchByTeacherId(Integer teacherId);
}
