<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社会考试成绩</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/student_courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/exam.js"></script>		
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">

			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-1">
					<a href="${pageContext.servletContext.contextPath}/studentCet" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>前往社会考试报名页面
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>社会考试成绩</h4>
				</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>社会考试名称</td>
							<td>准考证号</td>
							<td>社会考试时间</td>
							<td>社会考试地点</td>
							<td>考试成绩</td>
						</tr>
						<c:forEach items="${listScore }" var="result">
							<tr>
								<td>${result.name }</td>
								<td>${studentId }</td>
								<td id="date">${result.time }</td>
								<td>${result.place }</td>
								<td>${result.score }</td>
							</tr>							
						</c:forEach>
					</table>
				</div>
			</div>

			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>社会考试安排</h4>
				</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>社会考试地点</td>
							<td>是否已报名</td>
						</tr>
						<c:forEach items="${listApply }" var="result">
							<tr>
								<td>${result.name }</td>
								<td class="time">${result.time }</td>
								<td>${result.place }</td>
								<td>
									<c:if test="${result.place }==0">是</c:if>
									<c:if test="${result.place }==1">否</c:if>
								</td>
							</tr>						
						</c:forEach>
					</table>
				</div>
			</div>

			<!--列表组-->
			<div class="list-group col-md-1 col-md-pull-0">
				<a href="#" class="list-group-item disabled">
					<h4>社会考试</h4>
				</a>
				<a href="#" class="list-group-item active">社会考试成绩与安排</a>
				<a href="${pageContext.servletContext.contextPath}/studentCet" class="list-group-item">社会考试报名</a>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>