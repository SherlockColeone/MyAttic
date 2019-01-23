<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员个人中心</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/teacher/teacher_home.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		
		<!--主体-->
		<div id="main" class="container col-md-12">
			<div id="block" class="col-md-8 col-md-offset-2">
				<a href="${pageContext.servletContext.contextPath}/teacherMessage" id="message" class="col-md-4 btn" style="padding-top: 70px;">
					<img src="images/personal.png" />
					<div>管理员信息</div>
					<div>工号：${teacher.id }</div>
					<div>姓名：${teacher.name }</div>
					<div>身份：管理员</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/teacherCurriculum" id="curriculum" class="col-md-2 btn">
					<img src="images/curriculum.png" />
					<div>教师课程表</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/teacherCourses" id="courses" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/courses.png" />
					<div>课程安排</div>	
				</a>	
				<a href="${pageContext.servletContext.contextPath}/teacherExam" id="exam" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/exam.png" />
					<div>考试安排</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/teacherCurriculumarrange" id="curriculumarrange" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/curriculumarrange.png" />
					<div>调课通知</div>
				</a>				
				<a href="${pageContext.servletContext.contextPath}/teacherElective" id="elective" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/elective.png" />
					<div>选修课安排</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/teacherEvaluation" id="evaluation" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/evaluation.png" />
					<div>教师评价</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/teacherGradeCet" id="cet" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/cet.png" />
					<div>社会考试管理</div>
				</a>				
				<a href="${pageContext.servletContext.contextPath}/teacherStuscore" id="stuscore" class="col-md-4 btn" style="padding-top: 30px;">
					<img src="images/stuscore.png" />
					<div>学生成绩管理</div>
				</a>
				<a href="${pageContext.servletContext.contextPath}/password" id="password" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/password.png" />
					<div>密码管理</div>
				</a>
			</div>
		</div>
		
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>