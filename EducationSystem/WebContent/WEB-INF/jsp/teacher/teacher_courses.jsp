<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师课程安排</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>课程安排查询</h4>
				</div>
				<div id="buttonGroup" class="col-md-10 col-md-offset-2">
					<form action="${pageContext.servletContext.contextPath}/teacherSearchAllCourses" method="post">
						<div id="term" class="col-md-8 col-md-offset-3">
							开课时间：
							<select name="termId">
								<c:forEach items="${termList }" var="term">
									<option value="${term.id }">${term.termtime }</option>
								</c:forEach>
							</select>
						</div>
						<div id="courses" class="col-md-8 col-md-offset-3">
							课程性质：
							<select name="curriculum">
								<option value="0">不限性质</option>
								<option value="1">专业课</option>
								<option value="2">选修课</option>
							</select>
						</div>
						<div class="col-md-4 col-md-offset-4">
							<button type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-screenshot"></span>查询
							</button>
						</div>
					</form>
					
					<!-- 还可以添加搜索单个课程的功能 -->
					
				</div>
				<div class="col-md-6">
					查询条件：${term }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${nature }
				</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>课程编号</td>
							<td>课程名称</td>
							<td>开课时间</td>
							<td>课程性质</td>
						</tr>
						<c:forEach items="${resultList }" var="result">
							<tr>
								<td>${result.id }</td>
								<td>${result.name }</td>
								<td>${term }</td>
								<td>
									<c:if test="${not empty result.classesid }">
										专业课
									</c:if>
									<c:if test="${empty result.classesid }">
										选修课
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>