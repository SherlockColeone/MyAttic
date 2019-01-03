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
					<a href="#" class="btn btn-default">
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
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<a id="apply" href="#">报名</a>
							</td>
						</tr>
					</table>
				</div>

				<div id="single" class="col-md-12" style="display: none;">
					<table class="table table-striped">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>社会考试地点</td>
						</tr>
						<tr>
							<form action="" method="post">
								<td></td>
								<td>2018-06-16</td>
								<td></td>
							</form>
						</tr>
					</table>
					<div class="col-md-4 col-md-offset-4">
						<button id="submit" type="submit" class="btn btn-default">确定报名</button>
					</div>
				</div>
			</div>
			
			<!--列表组-->
			<div class="list-group col-md-1 col-md-pull-0">
				<a href="#" class="list-group-item disabled">
					<h4>社会考试</h4>
				</a>
				<a href="#" class="list-group-item">社会考试成绩与安排</a>
				<a href="#" class="list-group-item active">社会考试报名</a>`
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>