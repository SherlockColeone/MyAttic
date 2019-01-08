<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>选课中心</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/home_student.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/elective.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>选课中心</h4>
				</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<table class="table table-condensed">
							<tr>
								<td>选课编号</td>
								<td>课程名称</td>
								<td>任课老师</td>
								<td>课程时间</td>
								<td>操作</td>
							</tr>
							<tr>
								<td class="id">201811</td>
								<td class="name">侵权责任法</td>
								<td class="teacher">李晓敏</td>
								<td class="time">星期一&nbsp;&nbsp;07-08节</td>
								<td>
									<a href="#" class="btn apply" style="background-color: white;">选择课程</a>
								</td>
							</tr>							
						</table>
					</div>
					
					<div id="single" class="col-md-12" style="display: none;">
						<table class="table table-striped">
							<tr>
								<td>选课编号</td>
								<td>课程名称</td>
								<td>任课老师</td>
								<td>课程时间</td>
							</tr>
							<tr>
								<td id="showId"></td>
								<td id="showName"></td>
								<td id="showTeacher"></td>
								<td id="showTime"></td>
							</tr>
						</table>
						<div class="col-md-4 col-md-offset-5">
							<form action="#" method="post">
								<input id="id" name="id" hidden readonly />
								<button id="submit" type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-ok-circle"></span>
									确定报名
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>