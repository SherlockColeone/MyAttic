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
					<form action="${pageContext.servletContext.contextPath}/studentModifyPassword" method="post">
						当前登录账户：<input class="form-control" type="text" placeholder="${studentId }" readonly><br /> 
						旧密码：<input type="password" class="form-control" placeholder="请输入旧密码"><br />
						新密码：<input type="password" class="form-control" placeholder="请输入新密码"><br />
						确认新密码：<input type="password" class="form-control" placeholder="请确认新密码"><br />
						<div class="col-md-offset-5">
							<input type="submit" class="btn btn-info" value="提交" />
						</div>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>