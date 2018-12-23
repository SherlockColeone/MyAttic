<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>header</title>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/bootstrap-theme.css" />
		<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
	</head>

	<body>
		<div class="container col-md-12">
			<div id="top" class="col-lg-offset-2">
				<div class="col-md-6">
					<img src="../images/logo.png" />
				</div>
				<div class="col-md-offset-6">
					<div class="col-md-10">
						<div class="col-md-7">
							欢迎回来！周星星同学！
						</div>
						<div class="col-md-5">
							<a href="#" class="btn btn-primary btn-sm" role="button">注销</a>
						</div>
					</div>
				</div>
			</div>
			
			<!--导航栏-->
			<div id="navigator" class="col-md-12">
				<!-- 导航条中的导航组件 -->
				<ul class="nav nav-pills navbar-nav" style="background-color:#202020;color: gray;">
					<li>
						<a href="首页index.html" style="color: gray;font-size: 15px;">首页</a>
					</li>
					<li>
						<a href="产品列表list.html" style="color: gray;font-size: 15px;">个人信息</a>
					</li>
					<li>
						<a href="手机phone.html" style="color: gray;font-size: 15px;">课程安排</a>
					</li>
					<li>
						<a href="电脑pc.html" style="color: gray;font-size: 15px;">学生成绩</a>
					</li>
					<li>
						<a href="#" style="color: gray;font-size: 15px;">考试安排</a>
					</li>
					<li>
						<a href="#" style="color: gray;font-size: 15px;">其他</a>
					</li>					
					<li style="margin-left: 880px;margin-top: 0.5%;">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="search" />
						</div>
					</li>
					<li style="margin-left: 10px;margin-top: 0.5%;margin-right: 20px;">
						<button class="btn btn-default">submit</button>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>