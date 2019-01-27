<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生课程安排管理</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/courses.js"></script>		
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>学生课程安排管理</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="searchCurriculum" action="#" method="post">
						<div id="curriculum" class="col-md-4">
							操作：
							<input class="operate" type="radio" name="operate" value="1" />添加&nbsp;&nbsp;&nbsp;
							<input class="operate" type="radio" name="operate" value="2" />删除&nbsp;&nbsp;&nbsp;
							<input class="operate" type="radio" name="operate" value="3" />修改&nbsp;&nbsp;&nbsp;
						</div>
						<div id="term" class="col-md-4">
							课程编号：<input id="inputId" type="text" name="inputId" />
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询课程
							</button>
						</div>
					</form>
				</div>
				<div class="col-md-12">
					进行的操作：添加<br />
				</div>
				<div class="col-md-12">
					<form id="courses" action="#" method="post">
						<input id="manageResult" name="manageResult" value="" type="text" hidden="hidden" readonly="readonly" />
						<div class="col-md-12">
							<table class="table table-striped">
								<tr>
									<td>课程编号</td>
									<td>课程名称</td>
									<td>开课时间</td>
									<td>课程教师编号</td>
									<td>班级编号</td>
								</tr>
								<tr>
									<td>
										<input type="text" id="id" name="id" value="230" class="courses" />
										<button id="randomid" class="btn btn-info" name="id" type="button" value="0" style="margin-top: 5px;">随机分配编号</button>
									</td>
									<td>
										<input type="text" name="name" value="数据库原理及应用" class="courses" />
									</td>
									<td>
										<input type="text" name="week" value="1-16周" class="courses" />
									</td>
									<td>
										<input type="text" name="teacherid" value="2006100" class="courses" />
									</td>
									<td>
										<input type="text" name="classesid" value="1201" class="courses" />
									</td>
								</tr>
								<br />
								<tr>
									<td>星期几</td>
									<td>第几节</td>
									<td>上课地点</td>
									<td colspan="2">学期</td>
								</tr>
								<tr>
									<td>
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
										<select id="time" name="time" class="form-control" class="courses">
											<option value="01-02">01-02节</option>
											<option value="03-04">03-04节</option>
											<option value="05-06">05-06节</option>
											<option value="07-08">07-08节</option>
											<option value="09-10">09-10节</option>
										</select>
									</td>
									<td>
										<input type="text" name="place" value="16-301" class="courses" />
									</td>
									<td>
										<button id="currentTerm" class="btn btn-info" name="termid" type="button" value="20182">采用当前学期</button>
									</td>
									<td>
										<select id="termid" name="termid" class="form-control" class="courses">
											<option value="20181">2018-09-2019-01</option>
											<option value="20182">2019-03-2019-07</option>
											<option value="20191">2019-09-2020-01</option>
										</select>
									</td>
								</tr>
							</table>
						</div>
						<div id="confirm" class="col-md-10 col-md-offset-5">
							<button id="submit" type="submit" class="btn btn-success">
								<span class="glyphicon glyphicon-check"></span>提交信息
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>