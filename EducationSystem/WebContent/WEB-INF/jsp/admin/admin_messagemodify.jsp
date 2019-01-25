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
				<!--根据该按钮的值判断当前身份和操作-->
				<input id="identityResult" value="3" hidden="hidden" readonly="readonly" />
				<input id="manageResult" value="1" hidden="hidden" readonly="readonly" />
				<div class="col-md-12">
					当前操作:&nbsp;添加&nbsp;学生
				</div>
				<div class="col-md-12">
					<form id="message" action="#" method="post" enctype="multipart/form-data">
						<div class="col-md-12" id="forStudent">
							<!--学生专用的表格-->
							<table class="col-md-12">
								<tr>
									<td width="15%">姓名</td>
									<td><input type="text" name="name" value="周星星" class="input" /></td>
									<td width="15%">学号</td>
									<td colspan="2"><input type="text" name="id" value="2015121359527" class="longInput" /></td>
									<td rowspan="4">
										<img src="" />上传照片<br /><input type="file" name="photo" class="input" />
									</td>
								</tr>
								<tr>
									<td width="15%">身份证号</td>
									<td colspan="2"><input type="text" name="idcard" value="44XXXXXXXXXXXXXX10" class="longInput" /></td>
									<td>性别</td>
									<td><input type="text" name="sex" value="男" class="input" /></td>
								</tr>
								<tr>
									<td width="15%">籍贯</td>
									<td><input type="text" name="birthplace" value="广东省广州市" class="input" /></td>
									<td width="15%">家庭地址</td>
									<td colspan="2"><input type="text" name="address" value="广东省广州市" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">电话</td>
									<td><input type="text" name="phone" value="18000000000" class="input" /></td>
									<td width="15%">出生日期</td><!--此处可尝试使用日历-->
									<td colspan="2"><input type="text" name="birth" value="2015/01/01" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">民族</td>
									<td colspan="2"><input type="text" name="nation" value="汉族" class="longInput" /></td>
									<td>政治面貌</td>
									<td colspan="2">
										<select name="politics" class="longInput form-control">
											<option value="群众">群众</option>
											<option value="中共党员">中共党员</option>
											<option value="共青团员">共青团员</option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="15%">入学时间</td>
									<td colspan="2"><input type="text" name="regist" value="2015/09" class="longInput" /></td>
									<td>班级编号</td>
									<td colspan="2"><input type="text" name="nation" value="1201" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">二级学院</td>
									<td colspan="2">
										<select name="academy" class="longInput form-control">
											<option value="1">信息工程学院</option>
											<option value="2">外国语学院</option>
											<option value="3">人文学院</option>
											<option value="4">经济管理学院</option>
											<option value="5">会计学院</option>
											<option value="6">设计学院</option>
											<option value="7">传媒学院</option>
										</select>										
									</td>
									<td>专业</td>
									<td colspan="2"><input type="text" name="major" value="计算机科学与技术" class="longInput" /></td>
								</tr>
							</table>
						</div>

						<div class="col-md-12" id="forTeacher">
							<!--教师专用的表格-->
							<table class="col-md-12">
								<tr>
									<td width="15%">姓名</td>
									<td><input type="text" name="name" value="周星星" class="input" /></td>
									<td width="15%">工号</td>
									<td colspan="2"><input type="text" name="id" value="2015121359527" class="longInput" /></td>
									<td rowspan="4">
										<img src="" />上传照片<br /><input type="file" name="photo" class="input" />
									</td>
								</tr>
								<tr>
									<td width="15%">身份证号</td>
									<td colspan="2"><input type="text" name="idcard" value="44XXXXXXXXXXXXXX10" class="longInput" /></td>
									<td>性别</td>
									<td><input type="text" name="sex" value="男" class="input" /></td>
								</tr>
								<tr>
									<td width="15%">籍贯</td>
									<td><input type="text" name="birthplace" value="广东省广州市" class="input" /></td>
									<td width="15%">家庭地址</td>
									<td colspan="2"><input type="text" name="address" value="广东省广州市" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">电话</td>
									<td><input type="text" name="phone" value="18000000000" class="input" /></td>
									<td width="15%">出生日期</td>
									<td colspan="2"><input type="text" name="birth" value="2015/01/01" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">民族</td>
									<td colspan="2"><input type="text" name="nation" value="汉族" class="longInput" /></td>
									<td>政治面貌</td>
									<td colspan="2">
										<select id="identity" name="politics" class="longInput form-control">
											<option value="群众">群众</option>
											<option value="中共党员">中共党员</option>
											<option value="共青团员">共青团员</option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="15%">入职时间</td>
									<td colspan="2"><input type="text" name="entrytime" value="2015/09" class="longInput" /></td>
									<td>职位</td>
									<td colspan="2"><input type="text" name="position" value="教授" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">二级学院</td>
									<td colspan="2">
										<select name="academy" class="longInput form-control">
											<option value="1">信息工程学院</option>
											<option value="2">外国语学院</option>
											<option value="3">人文学院</option>
											<option value="4">经济管理学院</option>
											<option value="5">会计学院</option>
											<option value="6">设计学院</option>
											<option value="7">传媒学院</option>
										</select>
									</td>
									<td></td>
									<td colspan="2"></td>
								</tr>
							</table>
						</div>

						<div class="col-md-12" id="forAdmin">
							<!--管理员专用的表格-->
							<table class="col-md-12">
								<tr>
									<td width="15%">姓名</td>
									<td><input type="text" name="name" value="周星星" class="input" /></td>
									<td width="15%">工号</td>
									<td colspan="2"><input type="text" name="id" value="2015121359527" class="longInput" /></td>
									<td rowspan="4">
										<img src="" />上传照片<br /><input type="file" name="photo" class="input" />
									</td>
								</tr>
								<tr>
									<td width="15%">身份证号</td>
									<td colspan="2"><input type="text" name="idcard" value="44XXXXXXXXXXXXXX10" class="longInput" /></td>
									<td>性别</td>
									<td><input type="text" name="sex" value="男" class="input" /></td>
								</tr>
								<tr>
									<td width="15%">籍贯</td>
									<td><input type="text" name="birthplace" value="广东省广州市" class="input" /></td>
									<td width="15%">家庭地址</td>
									<td colspan="2"><input type="text" name="address" value="广东省广州市" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">电话</td>
									<td><input type="text" name="phone" value="18000000000" class="input" /></td>
									<td width="15%">出生日期</td>
									<td colspan="2"><input type="text" name="birth" value="2015/01/01" class="longInput" /></td>
								</tr>
								<tr>
									<td width="15%">民族</td>
									<td colspan="2"><input type="text" name="nation" value="汉族" class="longInput" /></td>
									<td>政治面貌</td>
									<td colspan="2">
										<select id="identity" name="politics" class="longInput form-control">
											<option value="群众">群众</option>
											<option value="中共党员">中共党员</option>
											<option value="共青团员">共青团员</option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="15%">入职时间</td>
									<td colspan="2"><input type="text" name="entrytime" value="2015/09" class="longInput" /></td>
									<td>职位</td>
									<td colspan="2"><input type="text" name="position" value="管理员" class="longInput" /></td>
								</tr>
							</table>
						</div>

						<div id="confirm" class="col-md-10 col-md-offset-5">
							<button id="submit" type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-save"></span>提交信息
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>