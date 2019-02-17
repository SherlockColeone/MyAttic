<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>申请调课</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/teacher/curriculumarrange.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<a href="${pageContext.servletContext.contextPath}/teacherCurriculumarrange" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>查看调课通知
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>申请调课</h4>
				</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<form id="curriculumarrangeSubmit" action="#" method="post">
							<tr>
								<td>课程名称</td>
								<td>课程周次</td>
								<td>调课后在星期几</td>
								<td>调课后在第几节</td>
							</tr>
							<tr>
								<td>
									<input class="input" value="数据库原理" type="text" />
								</td>
								<td>
									<input class="input" value="第8周" type="text" placeholder="第X周或第X周-第Y周" />
								</td>
								<td>
									<input class="define" value="星期二" hidden="hidden" />
									<select id="day" name="day" class="form-control" class="courses">
										<option value="1">星期一</option>
										<option value="2">星期二</option>
										<option value="3">星期三</option>
										<option value="4">星期四</option>
										<option value="5">星期五</option>
										<option value="6">星期六</option>
										<option value="7">星期日</option>
									</select>
								</td>
								<td>
									<input class="define" value="01-02节" hidden="hidden" />
									<select id="time" name="time" class="form-control" class="courses">
										<option value="01-02节">01-02节</option>
										<option value="03-04节">03-04节</option>
										<option value="05-06节">05-06节</option>
										<option value="07-08节">07-08节</option>
										<option value="09-10节">09-10节</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>调课后地点</td>
								<td>课程老师</td>
								<td>上课班级</td>
								<td>操作</td>
							</tr>
							<tr>
								<td>
									<input class="input" value="1-502" type="text" />
								</td>
								<td>
									<input class="input" value="风清扬" type="text" />
								</td>
								<td>
									<input class="input" value="计算机科学技术1501班" type="text" />
								</td>
								<td>
									<button class="btn btn-info" type="submit">提交</button>
								</td>
							</tr>
						</form>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>