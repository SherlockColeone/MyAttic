<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生教师评价</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/student_courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-4">
					<h4>学生教师评价</h4>
				</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<table class="table table-striped">
							<tr>
								<td>任课教师</td>
								<td>课程名称</td>
								<td>课程性质</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${list }" var="result">
								<tr>
									<td>风清扬</td>
									<td>数据库原理</td>
									<td>专业课</td>
									<td>
										<a href="#" class="">评价</a>
									</td>
								</tr>							
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>