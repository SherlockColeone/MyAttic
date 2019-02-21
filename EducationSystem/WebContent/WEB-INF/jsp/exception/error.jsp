<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>页面出现了异常</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/exception/error.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/exception/error.js"></script>
	</head>

	<body>
		<div class="container col-md-12">
			<div id="top" class="col-md-6 col-md-offset-4">
				<img src="images/logo.png" />
			</div>

			<div class="col-md-12">
				<c:if test="${not empty admin }">
					<input id="identity" value="1" hidden="hidden" readonly="readonly" />
				</c:if>
				<c:if test="${not empty teacher }">
					<input id="identity" value="2" hidden="hidden" readonly="readonly" />
				</c:if>
				<c:if test="${not empty student }">
					<input id="identity" value="3" hidden="hidden" readonly="readonly" />
				</c:if>
				<div id="content" class="col-md-8 col-md-offset-2" style="background-image: url(images/error.jpg);background-repeat: no-repeat;">
					<div id="hint" class="col-md-10 col-md-offset-5">
						<h3>抱歉，页面出现了错误……</h3>
					</div>					
					<div class="col-md-10 col-md-offset-6">
						<div class="link">
							<a id="home" href="#">返回首页>></a>
						</div>						
					</div>
					<div class="col-md-3 col-md-offset-4">
						<div class="link">
							<a id="message" href="#">个人信息>></a>
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="link">
							<a id="courses" href="#">课程安排>></a>
						</div>
					</div>
					<div class="col-md-3 col-md-offset-4">
						<div class="link">
							<a id="stuscore" href="#">学生成绩>></a>
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="link">
							<a id="exam" href="#">考试安排>></a>
						</div>
					</div>
					<div class="col-md-3 col-md-offset-4">
						<div class="link">
							<a id="elective" href="#">选课中心>></a>
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="link">
							<a id="password" href="${pageContext.servletContext.contextPath}/password">密码管理>></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	
</html>