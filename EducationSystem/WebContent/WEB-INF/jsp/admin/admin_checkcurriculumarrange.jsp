<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看教师调课</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/curriculumarrange.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<a href="${pageContext.servletContext.contextPath}/adminCurriculumarrange" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>教师调课管理页面
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>查看教师调课安排</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="curriculumarrangeSearch" action="${pageContext.servletContext.contextPath}/adminSearchCurriculumarrange" method="post">
						<div id="teacher" class="col-md-4 col-md-offset-2">
							教师工号：<input id="teacherid" type="text" name="teacherid" />
						</div>
						<div class="col-md-3">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询该教师的调课安排
							</button>
						</div>					
					</form>
				</div>				
				<div class="col-md-12">已批准的调课：（开学以来）</div>
				<div class="col-md-12">查询的教师工号：${teacherid }</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>课程编号</td>
							<td>课程周次</td>
							<td>调课后时间</td>
							<td>调课后地点</td>
							<td>课程性质</td>
							<td>上课班级编号</td>
							<td>是否已批准</td>
						</tr>
						<c:forEach items="${list }" var="result">
						<tr>
							<td>
								<c:if test="${result.coursesid==0 }">
									${result.electiveid }
								</c:if>
								<c:if test="${result.electiveid==0 }">
									${result.coursesid }
								</c:if>
							</td>
							<td>${result.week }</td>
							<td id="arrangeDate">
								<c:if test="${result.day==1 }">星期一</c:if>
								<c:if test="${result.day==2 }">星期二</c:if>
								<c:if test="${result.day==3 }">星期三</c:if>
								<c:if test="${result.day==4 }">星期四</c:if>
								<c:if test="${result.day==5 }">星期五</c:if>
								<c:if test="${result.day==6 }">星期六</c:if>
								<c:if test="${result.day==7 }">星期日</c:if>
								<br />${result.time }节
							</td>
							<td>${result.place }</td>
							<td>
								<c:if test="${result.coursesid==0 }">
									选修课
								</c:if>
								<c:if test="${result.electiveid==0 }">
									专业课
								</c:if>
							</td>
							<td>${result.classesid }</td>
							<td>
								<c:if test="${result.permit==-1 }">
									不批准
								</c:if>
								<c:if test="${result.permit==0 }">
									未批准
								</c:if>								
								<c:if test="${result.permit==1 }">
									已批准
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