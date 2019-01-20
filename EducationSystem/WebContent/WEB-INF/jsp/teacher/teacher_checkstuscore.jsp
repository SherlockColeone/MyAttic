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
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>查看学生成绩</h4>
				</div>
				<div id="buttonGroup" class="col-md-9 col-md-offset-2">
					<form action="${pageContext.servletContext.contextPath}/studentSearchAllStuscore" method="post">
						<div id="term" class="col-md-8 col-md-offset-3">
							学期时间：
							<select name="termId">
								<c:forEach items="${termList }" var="term">
									<option value="${term.id }">${term.termtime }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4 col-md-offset-4">
							<button type="submit" class="btn btn-default">查询</button>
						</div>
					</form>
					
					<!-- 还可以添加搜索单个课程的功能 -->
					
				</div>
				<div class="col-md-6">
					学期时间：${term }
				</div>
				<div class="col-md-12">
					<table class="table table-hover">
						<tr>
							<td>课程编号</td>
							<td>课程名称</td>
							<td>总成绩</td>
							<td>学分</td>
							<td>绩点</td>
							<td>课程性质</td>
							<td>学期时间</td>
						</tr>
						<c:forEach items="${resultList}" var="stuscore">
							<tr>
								<td>
									<c:if test="${stuscore.couresid!=0 }">
										${stuscore.couresid }
									</c:if>
									<c:if test="${stuscore.couresid==0 }">
										${stuscore.electiveid }
									</c:if>
								</td>
								<td>${stuscore.coursename }</td>
								<td>${stuscore.score }</td>
								<td>${stuscore.credit }</td>
								<td>${stuscore.point }</td>
								<td>
									<c:if test="${stuscore.couresid!=0 }">
										专业课
									</c:if>
									<c:if test="${stuscore.couresid==0 }">
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

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>