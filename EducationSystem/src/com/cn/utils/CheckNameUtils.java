package com.cn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Academy;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Classroom;
import com.cn.bean.Courses;
import com.cn.bean.Elective;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.dao.AcademyMapper;
import com.cn.dao.CetMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.ClassroomMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.MajorMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.TeacherMapper;
import com.cn.dao.TermMapper;

/**
 * 	用于把id转换成名字，包括所有的实体类
 * @author Sherlock
 *
 */
@Service
public class CheckNameUtils {
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
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private StudentMapper studentMapper;	
	@Autowired
	private ElectiveMapper electiveMapper;
	
	/**
	 * 	根据二级学院的id查询二级学院的名字
	 * @param academyId 二级学院id
	 * @return 二级学院的名字
	 */
	public String searchByAcademyId(Integer academyId) {
		//查询二级学院
		Academy academy = academyMapper.selectByPrimaryKey(academyId);
		//获取二级学院的名字
		return academy.getName();
	}
	
	/**
	 * 	根据专业的id查询专业的名字
	 * @param majorId 专业id
	 * @return 专业的名字
	 */
	public String searchByMajorId(Integer majorId) {
		Major major = majorMapper.selectByPrimaryKey(majorId);
		return major.getName();
	}
	
	/**
	 * 	根据班级的id查询班级的名字
	 * @param classesId 班级id
	 * @return 班级的名字
	 */
	public String searchByClassesId(Integer classesId) {
		Classes classes = classesMapper.selectByPrimaryKey(classesId);
		return classes.getName();
	}
	
	/**
	 * 	根据学期的id查询学期的名字
	 * @param termid 学期id
	 * @return 学期的名字
	 */
	public String searchByTermid(Integer termId) {
		Term term = termMapper.selectByPrimaryKey(termId);
		return term.getTermtime();
	}
	
	/**
	 * 	根据专业课的id查询专业课的名字
	 * @param coursesId 专业课id
	 * @return 专业课的名字
	 */
	public String searchByCoursesId(Integer coursesId) {
		Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
		return courses.getName();
	}
	
	/**
	 * 	根据选修课的id查询选修课的名字
	 * @param electiveId 选修课id
	 * @return 选修课名字
	 */
	public String searchByElectiveId(Integer electiveId) {
		Elective elective = electiveMapper.selectByPrimaryKey(electiveId);
		return elective.getName();
	}
	
	/**
	 * 	根据社会考试的id查询社会考试的名字
	 * @param cetId 社会考试id
	 * @return 社会考试的名字
	 */
	public String searchByCetId(Integer cetId) {
		Cet cet = cetMapper.selectByPrimaryKey(cetId);
		return cet.getCetname();
	}
	
	/**
	 * 	根据课室的id查询课室的名字
	 * @param classroomId 课室id
	 * @return 课室的名字
	 */
	public String searchByClassroomId(Integer classroomId) {
		Classroom classroom = classroomMapper.selectByPrimaryKey(classroomId);
		return classroom.getName();
	}
	
	/**
	 *	 把星期的数字转化成星期几，若返回空，则说明数字已超出1-7
	 * @param day 星期数字
	 * @return 返回星期几
	 */
	public String transformDay(Integer day) {
		switch (day) {
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		case 7:
			return "星期日";
		default:
			return null;
		}
	}
	
	/**
	 * 	根据教师工号查询教师的名字
	 * @param teacherId 教师工号
	 * @return 教师的名字
	 */
	public String searchByTeacherId(Integer teacherId) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
		return teacher.getName();
	}
	
	/**
	 * 	根据学生学号查询学生的名字
	 * @param studentId 学生学号
	 * @return 学生的名字
	 */
	public String searchByStudentId(Integer studentId) {
		Student student = studentMapper.selectByPrimaryKey(studentId);
		return student.getName();
	}
}
