<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>教务管理系统首页</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
	</head>

	<body>
		<!--内容-->
		<div id="main" class="container col-md-12">
			<div id="top">
				<img src="images/logo.png" class="col-md-offset-1" />
			</div>
			<div id="background" class="col-md-12">
				<div id="context" class="col-md-12">
					<div id="login" class="col-md-offset-7">
						<div id="title" class="col-md-offset-1">
							<h3>用户登录</h3>
							<span>USER LOGIN</span>
						</div>
						<form action="${pageContext.servletContext.contextPath}/studentLogin" method="post" id="form" class="bs-example bs-example-form col-md-offset-1">
							<div class="container col-md-12">
								<div class="input-group col-md-7">
									<div class="col-md-5">
										<label>身&nbsp;&nbsp;&nbsp;&nbsp;份:</label>
									</div>
									<div class="col-md-7">
										<select id="identity" name="identity" class="form-control">
											<option value="3">学生</option>
											<option value="2">教师</option>
											<option value="1">管理员</option>
										</select>
									</div>
								</div>
								<div class="input-group col-md-9">
									<div class="col-md-3">
										<label id="idLabel">学&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
									</div>
									<div class="col-md-9">
										<input id="id" type="text" name="id" class="form-control" placeholder="请输入学号或工号">
									</div>
								</div>
								<div class="input-group col-md-9">
									<div class="col-md-3">
										<label>密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
									</div>
									<div class="col-md-9">
										<input id="password" type="password" name="password" class="form-control" placeholder="请输入密码">
									</div>
								</div>
								<div class="input-group col-md-9">
									<div class="col-md-3">
										<label>验&nbsp;证&nbsp;&nbsp;码:</label>
									</div>
									<div class="col-md-9">
										<input id="check" type="text" class="form-control" placeholder="请输入验证码">
									</div>
								</div>
								<div class="col-md-9" style="margin-top: 10px;">
									<div id="code" class="col-md-6"></div>
									<a class="col-md-7">看不清，换一张</a>
								</div>
								<div id="loginBtn" class="col-md-8 col-md-offset-2">
									<button id="submit" type="submit" class="btn btn-primary">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>