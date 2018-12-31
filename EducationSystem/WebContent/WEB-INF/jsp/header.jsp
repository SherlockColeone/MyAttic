<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>header</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/header.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/header.js"></script>

	</head>

	<body>
		<div class="container col-md-12">
			<div id="top" class="col-md-10 col-lg-offset-2">
				<div class="col-md-6">
					<img src="images/logo.png" />
				</div>
				<div id="topRight" class="col-md-offset-6">
					<div class="col-md-10">
					<!-- 此处可以使用滚动文字marquee标签 -->
						<div class="col-md-6">
							欢迎回来！
							<c:if test="${not empty student }">
								${student.name }同学！
							</c:if>
							<c:if test="${not empty teacher }">
								${teacher.name }老师！
							</c:if>
							<c:if test="${not empty admin }">
								${admin.name }管理员！
							</c:if>
						</div>
						<div id="group" class="col-md-6">
							<div class="col-md-6 btn-group">
								<button type="button" class="btn dropdown-toggle change" data-toggle="dropdown">
									更改样式
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a id="DarkSeaGreen">浅绿色</a>
									</li>
									<li>
										<a id="SkyBlue">天蓝色</a>
									</li>
									<li>
										<a id="Black">黑&nbsp;&nbsp;&nbsp;&nbsp;色</a>
									</li>
								</ul>
							</div>
							<div class="col-md-6">
								<button id="quit" class="btn change" role="button">注销</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--导航栏-->
			<div id="navigator" class="col-md-12 change">
				<div class="col-md-offset-2">
					<!-- 导航条中的导航组件 -->
					<ul class="nav navbar-nav">
						<li>
							<a href="${pageContext.servletContext.contextPath}/home" class="change">网站首页</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/message" class="change">个人信息</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/courses" class="change">课程安排</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/stuscore" class="change">学生成绩</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/exam" class="change">考试安排</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/elective" class="change">选课中心</a>
						</li>
						<li>
							<a href="${pageContext.servletContext.contextPath}/pwd" class="change">密码管理</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>