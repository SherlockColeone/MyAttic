<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看学生课程安排</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/courses.js"></script>		
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-3">
					<a href="${pageContext.servletContext.contextPath}/adminCoursesModify" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>前往学生课程安排管理
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>查看学生课程安排</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-3">
					<form id="coursesSearchCurriculum" action="${pageContext.servletContext.contextPath}/adminCheckCoursesForCourses" method="post">
						<div id="term" class="col-md-4">
							课程编号：<input id="coursesInputId" type="text" name="inputId" />
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询课程
							</button>
						</div>
					</form>
				</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<table class="table table-striped">
							<tr>
								<td>课程编号</td>
								<td>课程名称</td>
								<td>开课时间</td>
								<td>课程教师编号</td>
								<td>课程教师姓名</td>
							</tr>
							<tr>
								<td>${courses.id }</td>
								<td>${courses.name }</td>
								<td>${courses.week }</td>
								<td>${courses.teacherid }</td>
								<td>${courses.teacher }</td>
							</tr>
							<br />
							<tr>
								<td>班级编号</td>
								<td>星期几</td>
								<td>第几节</td>
								<td>上课地点</td>
								<td>学期</td>
							</tr>
							<tr>
								<td>${courses.classesid }</td>
								<td>${courses.day }</td>
								<td>${courses.time }</td>
								<td>${courses.place }</td>
								<td>${termName }</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>