<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生个人中心</title>
		<link rel="stylesheet" href="../../css/bootstrap.css" />
		<link rel="stylesheet" href="../../css/bootstrap-theme.css" />
		<script type="text/javascript" src="../../js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="../../js/bootstrap.js" ></script>
		<script type="text/javascript" src="../../js/link.js" ></script>
		<script>
			$(function() {
				//添加外部html
				$("#header").load("../header.jsp");
				$("#footer").load("../footer.html");
			});
		</script>
	</head>
	<body>
		<div id="header"></div>
		
		<!--主体-->
		<div id="main">
			
		</div>
		
		<div id="footer"></div>
	</body>
</html>