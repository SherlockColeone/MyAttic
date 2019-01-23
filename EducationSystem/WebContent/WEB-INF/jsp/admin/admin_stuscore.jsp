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
				<div class="col-md-12">
					<div class="col-md-3">
						<a href="${pageContext.servletContext.contextPath}/teacherStuscore" class="btn btn-default">
							<span class="glyphicon glyphicon-arrow-left"></span>学生成绩管理页面
						</a>
					</div>
					<div class="col-md-3 col-md-offset-6">
						<a href="#" class="btn btn-default">
							留在本页面<span class="glyphicon glyphicon-arrow-right"></span>
						</a>
					</div>
				</div>			
				<div class="col-md-offset-5">
					<h4>查看学生成绩</h4>
				</div>
				<div>本学期您任教的课程:</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<table class="table table-condensed">
							<tr>
								<td>课程编号</td>
								<td>课程名称</td>
								<td>课程性质</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${list }" var="curr">
								<tr>
									<td>${curr.id }</td>
									<td>${curr.name }</td>
									<td>
										<c:if test="${curr.coursesid!=0 }">
											专业课
										</c:if>
										<c:if test="${curr.coursesid==0 }">
											选修课
										</c:if>
									</td>
									<td>
										<a href="${pageContext.servletContext.contextPath}/teacherSelectStuscore/${curr.id }/${curr.coursesid }" class="btn" style="background-color: white;">添加/修改成绩</a>
									</td>
								</tr>								
							</c:forEach>
						</table>
					</div>
				</div>
				
				<div class="col-md-6">
					已选择的课程：${curriculum }<br />
					该课程的所有学生：
				</div>
				<div class="col-md-12">
					<table class="table table-hover">
						<tr>
							<td>学号</td>
							<td>班级</td>
							<td>姓名</td>
							<td>总成绩</td>						
						</tr>
						<c:forEach items="${resultList }" var="score">
							<tr>
								<td>${score.studentid }</td>
								<td>${score.classes }</td>
								<td>${score.name }</td>
								<td>${score.score }</td>
							</tr>							
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>