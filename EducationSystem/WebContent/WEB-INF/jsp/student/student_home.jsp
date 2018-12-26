<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生个人中心</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/home_student.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		
		<!--主体-->
		<div id="main" class="container col-md-12">
			<div id="block" class="col-md-8 col-md-offset-2">
				<a href="${pageContext.servletContext.contextPath}/studentCurriculum" id="curriculum" class="col-md-2 btn">
					<img src="images/curriculum.png" />
					<div>课程表</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/studentMessage" id="message" class="col-md-4 btn" style="padding-top: 70px;">
					<img src="images/personal.png" />
					<div>学籍信息</div>
					<div>学号：${student.id }</div>
					<div>姓名：${student.name }</div>
					<div>身份：学生</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/studentCourses" id="courses" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/courses.png" />
					<div>课程安排</div>
				</a>				
				<a href="${pageContext.servletContext.contextPath}/studentExam" id="exam" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/exam.png" />
					<div>考试安排</div>
				</a>				
				<a href="#" id="elective" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/elective.png" />
					<div>选课中心</div>
				</a>
				<a href="#" id="curriculumarrange" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/curriculumarrange.png" />
					<div>调课通知</div>
				</a>			
				<a href="#" id="cet" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/cet.png" />
					<div>社会考试</div>
				</a>
				<a href="#" id="stuscore" class="col-md-4 btn" style="padding-top: 30px;">
					<img src="images/stuscore.png" />
					<div>课程成绩</div>
				</a>
				<a href="#" id="evaluation" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/evaluation.png" />
					<div>教师评价</div>
				</a>
				<a href="#" id="password" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/password.png" />
					<div>密码管理</div>
				</a>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>