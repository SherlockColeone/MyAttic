<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>密码管理</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/password.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/password.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12" style="margin-bottom: 15px;">
			<div class="col-md-8 col-md-offset-3">
				<div class="col-md-8">
					<center>
						<h4>密码管理</h4>
					</center>
				</div>
				<div class="col-md-8">
					<form action="#" method="post">
						当前登录账户：<input class="form-control" type="text" placeholder="账号……" readonly>
						<br /> 
						原始密码：<input id="password" name="pwd" type="password" class="form-control" placeholder="请输入原始密码">
						<div id="warnPwd"></div>
						<br /> 
						新密码：<input id="newPwd" name="newPwd" type="password" class="form-control" placeholder="请输入新密码，请用大小写英文字母、数字，长度为6-20个字符">
						<div id="warnNewPwd"></div>
						<br /> 
						确认新密码：<input id="rePwd" name="rePwd" type="password" class="form-control" placeholder="请确认新密码，要求两次密码一致">
						<div id="warnRePwd"></div>
						<br />
						<div class="col-md-offset-5">
							<button id="submit" type="submit" class="btn btn-info">提交</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>