<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社会考试成绩管理</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>社会考试成绩管理</h4>
				</div>
				<div class="col-md-12">
					<table class="table table-bordered">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>需要查询的学生学号</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${list }" var="cet">
							<form action="${pageContext.servletContext.contextPath}/teacherCheckGradecet" method="post">
								<tr>
									<td hidden>
										<input type="text" name="cetid" value="${cet.id }" hidden="hidden" readonly="readonly" />
									</td>
									<td class="name">${cet.cetname }</td>
									<td class="time">${cet.cettime }</td>
									<td class="qualification">
										<input type="text" name="studentid" />
									</td>
									<td class="apply">
										<button type="submit" class="btn" style="background-color: white;">查询成绩</button>
									</td>
								</tr>
							</form>							
						</c:forEach>
					</table>
				</div>

				<div class="col-md-6">
					社会考试名称：${beancet.name }<br />
					社会考试时间：${beancet.time }
				</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>班级</td>
							<td>姓名</td>
							<td>学号</td>
							<td>成绩</td>
						</tr>
						<tr>
							<td>${beancet.classes }</td>
							<td>${beancet.studentname }</td>
							<td>${beancet.studentid }</td>
							<td>${beancet.score }</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>