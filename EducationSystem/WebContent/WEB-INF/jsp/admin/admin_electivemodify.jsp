<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看选课</title>
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
					<h4>查看选课</h4>
				</div>
				<div>您任教的选修课程:</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<input id="iselected" value="${iselected }" hidden readonly />
						<table class="table table-condensed">
							<tr>
								<td>选修课编号</td>
								<td>课程名称</td>
								<td>课程时间</td>
								<td>上课地点</td>
								<td></td>
							</tr>
							<c:forEach items="${list }" var="result">
								<tr>
									<td>${result.electiveid }</td>
									<td>${result.name }</td>
									<td>${result.time }</td>
									<td>${result.place }</td>
									<td>
										<form action="${pageContext.servletContext.contextPath}/teacherSearchAllStudent/${result.electiveid }" method="post">
											<button type="submit">查看学生名单</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
					<div id="single" class="col-md-12">
						<div>
							课程名称：${elective.name }<br />
							学生名单如下:
						</div>
						<table class="table table-condensed">
							<tr>
								<td>班级</td>
								<td>姓名</td>
								<td>学号</td>
							</tr>
							<c:forEach items="${studentList }" var="student">
								<tr>
									<td>${student.classes }</td>
									<td>${student.name }</td>
									<td>${student.id }</td>
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