<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看学生成绩</title>
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
				<div class="col-md-12">
					<div class="col-md-3">
						<a href="#" class="btn btn-default">
							<span class="glyphicon glyphicon-arrow-left"></span>班级专业课录入页面
						</a>
					</div>
				</div>
				<div class="col-md-offset-5">
					<h4>查看学生成绩</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="coursesSearchCurriculum" action="#" method="post">
						<div id="term" class="col-md-4">
							学生学号：<input id="coursesInputId" type="text" name="inputId" />
						</div>
						<div id="term" class="col-md-4">
							学期时间：
							<select name="termid">
								<option value="20181">2018-09-2019-01</option>
								<option value="20182">2019-03-2019-07</option>
								<option value="20191">2019-09-2020-01</option>
							</select>
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询学生成绩
							</button>
						</div>					
					</form>
				</div>
								
				<div class="col-md-12">
					<div>学号：&nbsp;&nbsp;学期时间：</div>
					<div class="col-md-12">
						<table class="table table-condensed">
							<tr>
								<td>课程编号</td>
								<td>课程名称</td>
								<td>总成绩</td>
								<td>课程性质</td>
								<td>学期时间</td>
							</tr>
							<tr>
								<td>230</td>
								<td>数据库原理及应用</td>								
								<td>88</td>
								<td>专业课</td>
								<td>专业课</td>
							</tr>
							<tr>
								<td>201812</td>
								<td>广告鉴赏</td>								
								<td>96</td>
								<td>选修课</td>
								<td>专业课</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>