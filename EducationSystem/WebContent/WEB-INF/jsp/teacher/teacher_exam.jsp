<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>考试安排</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/exam.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>本学期考试安排</h4>
				</div>
				<div class="col-md-6">监考老师：${teacherName }（仅限于本学期）</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>课程编号</td>
							<td>考试课程</td>
							<td>考试时间</td>
							<td>考试地点</td>
							<td>考试班级</td>
						</tr>
						<c:forEach items="${list }" var="result">
							<tr>
								<td>${result.coursesid }</td>
								<td>${result.name }</td>
								<td class="time">${result.time }</td>
								<td>${result.place }</td>
								<td>${result.classes }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>			
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>