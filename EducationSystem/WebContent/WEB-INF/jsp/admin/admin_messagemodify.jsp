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
					<a href="${pageContext.servletContext.contextPath}/adminMessage" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>查看管理员个人信息
					</a>
				</div>
				<div class="col-md-4 col-md-offset-1">
					<center>
						<h4>师生个人信息中心</h4>
					</center>
				</div>
				<div id="select" class="col-md-12">
					<form id="form" action="${pageContext.servletContext.contextPath}/adminSearchUser" method="post">
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
				<div class="col-md-12" id="showForm">
					<div class="col-md-12">
						当前操作:&nbsp;
						<c:if test="${manageResult }==1">添加</c:if>
						<c:if test="${manageResult }==2">删除</c:if>
						<c:if test="${manageResult }==3">修改</c:if>
						&nbsp;
						<c:if test="${identityResult }==3">学生</c:if>
						<c:if test="${identityResult }==2">教师</c:if>
						<c:if test="${identityResult }==1">管理员</c:if>
					</div>
					<div class="col-md-12">
						<form id="message" action="#" method="post" enctype="multipart/form-data">
							<!--根据该按钮的值判断当前身份和操作-->
							<input id="identityResult" name="identityResult" value="${identityResult }" hidden="hidden" readonly="readonly" />
							<input id="manageResult" name="manageResult" value="${manageResult }" hidden="hidden" readonly="readonly" />
							<div class="col-md-12" id="forStudent">
								<!--学生专用的表格-->
								<table class="col-md-12">
									<tr>
										<td width="15%">姓名</td>
										<td><input type="text" name="student.name" value="${student.name }" class="input" /></td>
										<td width="15%">学号</td>
										<td colspan="2"><input type="text" name="student.id" value="${student.id }" class="longInput" /></td>
										<td rowspan="4">
											<img src="" />上传照片<br /><input type="file" name="student.photo" class="input" />
										</td>
									</tr>
									<tr>
										<td width="15%">身份证号</td>
										<td colspan="2"><input type="text" name="student.idcard" value="${student.idcard }" class="longInput" /></td>
										<td>性别</td>
										<td>
											<input class="define" value="${student.sex }" hidden="hidden" readonly="readonly" />
											<select id="identity" name="student.sex" class="form-control">
												<option value="男">男</option>
												<option value="女">女</option>
											</select>
										</td>
									</tr>
									<tr>
										<td width="15%">籍贯</td>
										<td><input type="text" name="student.birthplace" value="${student.birthplace }" class="input" /></td>
										<td width="15%">家庭地址</td>
										<td colspan="2"><input type="text" name="student.address" value="${student.address }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">电话</td>
										<td><input type="text" name="student.phone" value="${student.phone }" class="input" /></td>
										<td width="15%">出生日期</td>
										<!--此处可尝试使用日历-->
										<td colspan="2"><input type="text" name="student.birth" value="${student.birth }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">民族</td>
										<td colspan="2"><input type="text" name="student.nation" value="${student.nation }" class="longInput" /></td>
										<td>政治面貌</td>
										<td colspan="2">
											<input class="define" value="${student.politics }" hidden="hidden" readonly="readonly" />
											<select name="student.politics" class="longInput form-control">
												<option value="群众">群众</option>
												<option value="中共党员">中共党员</option>
												<option value="共青团员">共青团员</option>
											</select>
										</td>
									</tr>
									<tr>
										<td width="15%">入学时间</td>
										<td colspan="2"><input type="text" name="student.regist" value="${student.regist }" class="longInput" /></td>
										<td>班级编号</td>
										<td colspan="2"><input type="text" name="student.classesid" value="${student.nation }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">二级学院</td>
										<td colspan="2">
											<input class="define" value="${student.academyid }" hidden="hidden" readonly="readonly" />
											<select name="student.academyid" class="longInput form-control">
												<option value="1">信息工程学院</option>
												<option value="2">外国语学院</option>
												<option value="3">人文学院</option>
												<option value="4">经济管理学院</option>
												<option value="5">会计学院</option>
												<option value="6">设计学院</option>
												<option value="7">传媒学院</option>
											</select>
										</td>
										<td>专业编号</td>
										<td colspan="2"><input type="text" name="student.majorid" value="${student.majorid }" class="longInput" /></td>
									</tr>
								</table>
							</div>

							<div class="col-md-12" id="forTeacher">
								<!--教师专用的表格-->
								<table class="col-md-12">
									<tr>
										<td width="15%">姓名</td>
										<td><input type="text" name="teacher.name" value="${teacher.name }" class="input" /></td>
										<td width="15%">工号</td>
										<td colspan="2"><input type="text" name="teacher.id" value="${teacher.id }" class="longInput" /></td>
										<td rowspan="4">
											<img src="" />上传照片<br /><input type="file" name="teacher.photo" class="input" />
										</td>
									</tr>
									<tr>
										<td width="15%">身份证号</td>
										<td colspan="2"><input type="text" name="teacher.idcard" value="${teacher.idcard }" class="longInput" /></td>
										<td>性别</td>
										<td>
											<input class="define" value="${teacher.sex }" hidden="hidden" readonly="readonly" />
											<select id="identity" name="teacher.sex" class="form-control">
												<option value="男">男</option>
												<option value="女">女</option>
											</select>
										</td>
									</tr>
									<tr>
										<td width="15%">籍贯</td>
										<td><input type="text" name="teacher.birthplace" value="${teacher.birthplace }" class="input" /></td>
										<td width="15%">家庭地址</td>
										<td colspan="2"><input type="text" name="teacher.address" value="${teacher.address }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">电话</td>
										<td><input type="text" name="teacher.phone" value="${teacher.phone }" class="input" /></td>
										<td width="15%">出生日期</td>
										<td colspan="2"><input type="text" name="teacher.birth" value="${teacher.birth }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">民族</td>
										<td colspan="2"><input type="text" name="teacher.nation" value="${teacher.nation }" class="longInput" /></td>
										<td>政治面貌</td>
										<td colspan="2">
											<input class="define" value="${teacher.politics }" hidden="hidden" readonly="readonly" />
											<select id="identity" name="teacher.politics" class="longInput form-control">
												<option value="群众">群众</option>
												<option value="中共党员">中共党员</option>
												<option value="共青团员">共青团员</option>
											</select>
										</td>
									</tr>
									<tr>
										<td width="15%">入职时间</td>
										<td colspan="2"><input type="text" name="teacher.entrytime" value="${teacher.entrytime }" class="longInput" /></td>
										<td>职位</td>
										<td colspan="2"><input type="text" name="teacher.position" value="${teacher.position }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">二级学院</td>
										<td colspan="2">
											<input class="define" value="${teacher.academyid }" hidden="hidden" readonly="readonly" />
											<select name="teacher.academyid" class="longInput form-control">
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
										<td><input type="text" name="admin.name" value="${admin.name }" class="input" /></td>
										<td width="15%">工号</td>
										<td colspan="2"><input type="text" name="admin.id" value="${admin.id }" class="longInput" /></td>
										<td rowspan="4">
											<img src="" />上传照片<br /><input type="file" name="admin.photo" class="input" />
										</td>
									</tr>
									<tr>
										<td width="15%">身份证号</td>
										<td colspan="2"><input type="text" name="admin.idcard" value="${admin.idcard }" class="longInput" /></td>
										<td>性别</td>
										<td>
											<input class="define" value="${admin.sex }" hidden="hidden" readonly="readonly" />
											<select id="identity" name="admin.sex" class="form-control">
												<option value="男">男</option>
												<option value="女">女</option>
											</select>
										</td>
									</tr>
									<tr>
										<td width="15%">籍贯</td>
										<td><input type="text" name="admin.birthplace" value="${admin.birthplace }" class="input" /></td>
										<td width="15%">家庭地址</td>
										<td colspan="2"><input type="text" name="admin.address" value="${admin.address }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">电话</td>
										<td><input type="text" name="admin.phone" value="${admin.phone }" class="input" /></td>
										<td width="15%">出生日期</td>
										<td colspan="2"><input type="text" name="admin.birth" value="${admin.birth }" class="longInput" /></td>
									</tr>
									<tr>
										<td width="15%">民族</td>
										<td colspan="2"><input type="text" name="admin.nation" value="${admin.nation }" class="longInput" /></td>
										<td>政治面貌</td>
										<td colspan="2">
											<input class="define" value="${admin.politics }" hidden="hidden" readonly="readonly" />
											<select id="identity" name="admin.politics" class="longInput form-control">
												<option value="群众">群众</option>
												<option value="中共党员">中共党员</option>
												<option value="共青团员">共青团员</option>
											</select>
										</td>
									</tr>
									<tr>
										<td width="15%">入职时间</td>
										<td colspan="2"><input type="text" name="admin.entrytime" value="${admin.entrytime }" class="longInput" /></td>
										<td>职位</td>
										<td colspan="2"><input type="text" name="admin.position" value="${admin.position }" class="longInput" /></td>
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
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>