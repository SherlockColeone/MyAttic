<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师个人信息</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/student_message.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-6 col-md-offset-3">
				<center>
					<h4>教师信息</h4>
				</center>
				<div id="up" class="col-md-12">
				<span class="col-md-4">
					院系：${academy }
				</span>	
				<span class="col-md-4">
					职位：${teacher.position }
				</span>
				<span class="col-md-4">
					工号：${teacher.id }
				</span>
				</div>
				<table class="col-md-12">
					<tr>
						<td width="15%">姓名</td>
						<td>${teacher.name }</td>
						<td width="15%">学号</td>
						<td colspan="2">${teacher.id }</td>						
						<td rowspan="4">
							<img src="${teacher.photo }" />
						</td>
					</tr>
					<tr>
						<td width="15%">身份证号</td>
						<td colspan="2">${teacher.idcard }</td>
						<td>性别</td>
						<td>男</td>
					</tr>
					<tr>
						<td width="15%">籍贯</td>
						<td>${teacher.birthplace }</td>
						<td width="15%">家庭地址</td>
						<td colspan="2">${teacher.address }</td>						
					</tr>
					<tr>
						<td width="15%">电话</td>
						<td>${teacher.phone }</td>
						<td width="15%">出生日期</td>
						<td colspan="2">${teacher.birth }</td>
					</tr>
					<tr>
						<td width="15%">民族</td>
						<td colspan="2">${teacher.nation }</td>
						<td>政治面貌</td>
						<td colspan="2">${teacher.politics }</td>
					</tr>
					<tr>
						<td width="15%">二级学院</td>
						<td colspan="2">${academy }</td>
						<td>职位</td>
						<td colspan="2">${teacher.position }</td>
					</tr>
					<tr>
						<td width="15%">入职时间</td>
						<td colspan="2">${teacher.entrytime }</td>						
						<td></td>
						<td colspan="2"></td>
					</tr>
				</table>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>