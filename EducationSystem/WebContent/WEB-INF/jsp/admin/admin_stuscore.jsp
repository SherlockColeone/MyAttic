<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看学生成绩</title>
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
				<div class="col-md-12">
					<div class="col-md-3">
						<a href="${pageContext.servletContext.contextPath}/adminStuscoremodify" class="btn btn-default">
							<span class="glyphicon glyphicon-arrow-left"></span>班级专业课录入页面
						</a>
					</div>
				</div>
				<div class="col-md-offset-5">
					<h4>查看学生成绩</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="stuscoreSearch" action="${pageContext.servletContext.contextPath}/adminCheckStuscore" method="post">
						<div id="student" class="col-md-4">
							学生学号：<input id="studentid" type="text" name="studentid" />
						</div>
						<div id="term" class="col-md-4">
							学期时间：
							<select name="termid">
							<c:forEach items="${termList }" var="term">
								<option value="${term.id }">${term.termtime }</option>
							</c:forEach>								
							</select>
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询学生成绩
							</button>
						</div>					
					</form>
				</div>
								
				<div class="col-md-12">
					<div>查询条件：学号：${studentid }&nbsp;&nbsp;学期时间：${termName }</div>
					<div class="col-md-12">
						<table class="table table-condensed">
							<tr>
								<td>学生姓名</td>
								<td>课程编号</td>
								<td>课程名称</td>
								<td>总成绩</td>
								<td>课程性质</td>
								<td>学期时间</td>
							</tr>
							<c:forEach items="${resultList }" var="result">
							<tr>
								<td>${studentName }</td>
								<td>${result.id }</td>
								<td>${result.coursename }</td>
								<td>${result.score }</td>
								<td>
									<c:if test="${result.couresid!=0 }">
										专业课
									</c:if>
									<c:if test="${result.couresid==0 }">
										选修课
									</c:if>
								</td>
								<td>${term }</td>
							</tr>							
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>