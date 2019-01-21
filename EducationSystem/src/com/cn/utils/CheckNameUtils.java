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
 * 	���ڰ�idת�������֣��������е�ʵ����
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
	 * 	���ݶ���ѧԺ��id��ѯ����ѧԺ������
	 * @param academyId ����ѧԺid
	 * @return ����ѧԺ������
	 */
	public String searchByAcademyId(Integer academyId) {
		//��ѯ����ѧԺ
		Academy academy = academyMapper.selectByPrimaryKey(academyId);
		//��ȡ����ѧԺ������
		return academy.getName();
	}
	
	/**
	 * 	����רҵ��id��ѯרҵ������
	 * @param majorId רҵid
	 * @return רҵ������
	 */
	public String searchByMajorId(Integer majorId) {
		Major major = majorMapper.selectByPrimaryKey(majorId);
		return major.getName();
	}
	
	/**
	 * 	���ݰ༶��id��ѯ�༶������
	 * @param classesId �༶id
	 * @return �༶������
	 */
	public String searchByClassesId(Integer classesId) {
		Classes classes = classesMapper.selectByPrimaryKey(classesId);
		return classes.getName();
	}
	
	/**
	 * 	����ѧ�ڵ�id��ѯѧ�ڵ�����
	 * @param termid ѧ��id
	 * @return ѧ�ڵ�����
	 */
	public String searchByTermid(Integer termId) {
		Term term = termMapper.selectByPrimaryKey(termId);
		return term.getTermtime();
	}
	
	/**
	 * 	����רҵ�ε�id��ѯרҵ�ε�����
	 * @param coursesId רҵ��id
	 * @return רҵ�ε�����
	 */
	public String searchByCoursesId(Integer coursesId) {
		Courses courses = coursesMapper.selectByPrimaryKey(coursesId);
		return courses.getName();
	}
	
	/**
	 * 	����ѡ�޿ε�id��ѯѡ�޿ε�����
	 * @param electiveId ѡ�޿�id
	 * @return ѡ�޿�����
	 */
	public String searchByElectiveId(Integer electiveId) {
		Elective elective = electiveMapper.selectByPrimaryKey(electiveId);
		return elective.getName();
	}
	
	/**
	 * 	������ῼ�Ե�id��ѯ��ῼ�Ե�����
	 * @param cetId ��ῼ��id
	 * @return ��ῼ�Ե�����
	 */
	public String searchByCetId(Integer cetId) {
		Cet cet = cetMapper.selectByPrimaryKey(cetId);
		return cet.getCetname();
	}
	
	/**
	 * 	���ݿ��ҵ�id��ѯ���ҵ�����
	 * @param classroomId ����id
	 * @return ���ҵ�����
	 */
	public String searchByClassroomId(Integer classroomId) {
		Classroom classroom = classroomMapper.selectByPrimaryKey(classroomId);
		return classroom.getName();
	}
	
	/**
	 *	 �����ڵ�����ת�������ڼ��������ؿգ���˵�������ѳ���1-7
	 * @param day ��������
	 * @return �������ڼ�
	 */
	public String transformDay(Integer day) {
		switch (day) {
		case 1:
			return "����һ";
		case 2:
			return "���ڶ�";
		case 3:
			return "������";
		case 4:
			return "������";
		case 5:
			return "������";
		case 6:
			return "������";
		case 7:
			return "������";
		default:
			return null;
		}
	}
	
	/**
	 * 	���ݽ�ʦ���Ų�ѯ��ʦ������
	 * @param teacherId ��ʦ����
	 * @return ��ʦ������
	 */
	public String searchByTeacherId(Integer teacherId) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
		return teacher.getName();
	}
	
	/**
	 * 	����ѧ��ѧ�Ų�ѯѧ��������
	 * @param studentId ѧ��ѧ��
	 * @return ѧ��������
	 */
	public String searchByStudentId(Integer studentId) {
		Student student = studentMapper.selectByPrimaryKey(studentId);
		return student.getName();
	}
}
