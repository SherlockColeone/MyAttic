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
						<table class="table table-striped">
							<tr>
								<td>选课编号</td>
								<td>课程名称</td>
								<td>任课老师</td>
								<td>课程时间</td>								
								<td>操作</td>
							</tr>
							<c:forEach items="${list }" var="result">
								<tr>
									<td>1</td>
									<td>侵权责任法</td>
									<td>李晓敏</td>
									<td>
										星期一<br />07-08节
									</td>
									<td>
										<a href="#">选择课程</a>
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