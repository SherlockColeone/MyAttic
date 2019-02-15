<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师调课管理</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/curriculumarrange.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<a href="${pageContext.servletContext.contextPath}/adminMessage" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>查看教师调课页面
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>教师调课管理</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="curriculumarrangeSearch" action="#" method="post">
						<div id="teacher" class="col-md-4 col-md-offset-2">
							教师工号：<input id="teacherid" type="text" name="teacherid" />
						</div>
						<div class="col-md-3">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询该教师的调课安排
							</button>
						</div>					
					</form>
				</div>
				<div class="col-md-6">查询的教师工号：</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>课程名称</td>
							<td>课程周次</td>
							<td>调课后时间</td>
							<td>调课后地点</td>
							<td>课程老师</td>
							<td>上课班级</td>
						</tr>
						<tr>
							<td>数据库原理</td>
							<td>第8周</td>
							<td id="arrangeDate">
								星期二<br />01-02节
							</td>
							<td>1-502</td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>