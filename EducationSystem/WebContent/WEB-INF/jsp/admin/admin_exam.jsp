<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>考试安排管理</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/exam.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-3">
					<a href="${pageContext.servletContext.contextPath}/adminExamModify" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>前往考试安排管理
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>查看本学期考试安排</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-3">
					<form id="examSearchCurriculum" action="${pageContext.servletContext.contextPath}/adminCheckExam" method="post">
						<div id="term" class="col-md-4">
							考试安排编号：<input id="coursesInputId" type="text" name="inputId" />
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询考试安排
							</button>
						</div>
					</form>
				</div>				
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>课程编号</td>
							<td>考试课程编号</td>
							<td>考试日期</td>
							<td>考试具体时间</td>
							<td>考试地点</td>
							<td>考试班级编号</td>
							<td>监考老师编号</td>
						</tr>
						<tr>
							<td>${exam.id }</td>
							<td>${exam.coursesid }</td>
							<td id="dayexam"></td>
							<td id="timeexam"></td>
							<input id="examtime" name="examtime" value="${exam.examtime }" type="text" hidden="hidden" readonly="readonly" />
							<td>${exam.place }</td>
							<td>${exam.classesid }</td>
							<td>${exam.teacherid }</td>
						</tr>
					</table>
				</div>
			</div>			
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>