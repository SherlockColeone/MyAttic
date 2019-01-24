<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>师生个人信息管理中心</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/admin/admin_messagemodify.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/messagemodify.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-6 col-md-offset-3">
				<div class="col-md-3">
					<a href="#" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>查看管理员个人信息
					</a>
				</div>
				<div class="col-md-4 col-md-offset-1">
					<center>
						<h4>师生个人信息中心</h4>
					</center>
				</div>
				<div id="select" class="col-md-12">
					<form id="form" action="#" method="post">
						<div class="col-md-12">
							选择进行操作的身份：
							<select id="identity" name="identity" class="form-control">
								<option value="3">学生</option>
								<option value="2">教师</option>
								<option value="1">管理员</option>
							</select>
							<span class="idLabel">学号：</span>
							<input id="inputId" type="text" name="id" /> 操作：
							<input class="operate" type="radio" name="operate" value="1" />添加&nbsp;&nbsp;&nbsp;
							<input class="operate" type="radio" name="operate" value="2" />删除&nbsp;&nbsp;&nbsp;
							<input class="operate" type="radio" name="operate" value="3" />修改&nbsp;&nbsp;&nbsp;
						</div>
						<div id="confirm" class="col-md-10 col-md-offset-5">
							<button type="submit" class="btn btn-primary">确定</button>
						</div>
					</form>
				</div>
				<form id="message" action="#" method="post" enctype="multipart/form-data">
					<table class="col-md-12">
						<tr>
							<td width="15%">姓名</td>
							<td>周星星</td>
							<td width="15%" class="idLabel">学号</td><!--会出现bug：即使查出结果也会随着下拉框而改变-->
							<td colspan="2">2015121359527</td>
							<td rowspan="4">
								<img src="" />照片
							</td>
						</tr>
						<tr>
							<td width="15%">身份证号</td>
							<td colspan="2">44XXXXXXXXXXXXXX10</td>
							<td>性别</td>
							<td>男</td>
						</tr>
						<tr>
							<td width="15%">籍贯</td>
							<td>广东省广州市</td>
							<td width="15%">家庭地址</td>
							<td colspan="2">广东省广州市</td>
						</tr>
						<tr>
							<td width="15%">电话</td>
							<td>18000000000</td>
							<td width="15%">出生日期</td>
							<td colspan="2">2015/01/01</td>
						</tr>
						<tr>
							<td width="15%">民族</td>
							<td colspan="2">汉族</td>
							<td>政治面貌</td>
							<td colspan="2">群众</td>
						</tr>
						<tr>
							<td width="15%">入职时间</td>
							<td colspan="2">2015/09</td>
							<td>职位</td>
							<td colspan="2">教授</td>
						</tr>
						<tr id="academy">
							<td width="15%">二级学院</td>
							<td colspan="2">信息工程学院</td>
							<td>专业</td>
							<td colspan="2">计算机科学与技术</td>
						</tr>
					</table>
					<div id="confirm" class="col-md-10 col-md-offset-5">
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-save"></span>提交信息
						</button>
					</div>
				</form>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>