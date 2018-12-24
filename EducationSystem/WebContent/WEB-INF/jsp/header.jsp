<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>header</title>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/bootstrap-theme.css" />
		<link rel="stylesheet" href="../css/header.css" />
		<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>		
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/header.js"></script>
	</head>

	<body>
		<div class="container col-md-12">
			<div id="top" class="col-md-10 col-lg-offset-2">
				<div class="col-md-6">
					<img src="../images/logo.png" />
				</div>
				<div id="topRight" class="col-md-offset-6">
					<div class="col-md-10">
						<div class="col-md-7">
							欢迎回来！周星星同学！
						</div>
						<div id="group" class="col-md-5">
							<div class="col-md-6">
								<a href="#" id="changeColor" class="btn" role="button">颜色更改</a>
							</div>
							<div class="col-md-6">
								<a href="#" id="quit" class="btn" role="button">注销</a>
							</div>
						</div>
					</div>
				</div>
			</div>
					
			<!--导航栏-->
			<div id="navigator" class="col-md-12">
				<div class="col-md-offset-3">
					<!-- 导航条中的导航组件 -->
					<ul class="nav navbar-nav">
						<li>
							<a href="首页index.html">首页</a>
						</li>
						<li>
							<a href="产品列表list.html">个人信息</a>
						</li>
						<li>
							<a href="手机phone.html">课程安排</a>
						</li>
						<li>
							<a href="电脑pc.html">学生成绩</a>
						</li>
						<li>
							<a href="#">考试安排</a>
						</li>
						<li>
							<a href="#">选课中心</a>
						</li>
						<li>
							<a href="#">其他</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>