<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社会考试报名</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/student_courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/cet.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-1">
					<a href="${pageContext.servletContext.contextPath}/studentGradeCet" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>前往社会考试成绩页面
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>社会考试报名</h4>
				</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>是否具备报名资格</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${list }" var="result">
							<tr>
								<td class="cetId" hidden>${result.score }</td>
								<td class="name">${result.name }</td>
								<td class="time">${result.time }</td>
								<td class="qualification">
									<c:if test="${result.qualification==0 }">是</c:if>
									<c:if test="${result.qualification==1 }">否</c:if>
								</td>
								<td>
									
									<!-- 未解决的问题：当不能报名时无法点击链接 -->
									
									<a class="apply" href="#">报名</a>
								</td>
							</tr>							
						</c:forEach>
					</table>
				</div>

				<div id="single" class="col-md-12" style="display: none;">
					<table class="table table-striped">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>学号</td>
						</tr>
						<tr>
							<td id="showName"></td>
							<td id="showTime"></td>
							<td>${studentId }</td>
						</tr>
					</table>
					<div class="col-md-4 col-md-offset-5">
						<form action="#" method="post">
							<input id="cetId" name="cetId" hidden readonly />
							<button id="submit" type="submit" class="btn btn-default">确定报名</button>
						</form>
					</div>
				</div>
			</div>
			
			<!--列表组-->
			<div class="list-group col-md-1 col-md-pull-0">
				<a href="#" class="list-group-item disabled">
					<h4>社会考试</h4>
				</a>
				<a href="${pageContext.servletContext.contextPath}/studentGradeCet" class="list-group-item">社会考试成绩与安排</a>
				<a href="#" class="list-group-item active">社会考试报名</a>`
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>