<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生成绩管理</title>
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
					<h4>学生成绩管理</h4>
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
					<form action="#" method="post">
						<table class="table table-hover">
							<tr>
								<td>学号</td>
								<td>班级</td>
								<td>姓名</td>
								<td>平时成绩</td>
								<td>期末成绩</td>
								<td>总成绩</td>						
							</tr>
							<c:forEach items="${resultList }" var="score">
								<tr>
									<td>
										${score.studentid }
										<input name="studentid" type="text" value="${score.studentid }" hidden="hidden" readonly="readonly" />
										<input name="curriculumId" type="text" value="${score.curriculumId }" hidden="hidden" readonly="readonly" />
									</td>
									<td>${score.classes }</td>
									<td>${score.name }</td>
									<td>								
										<input name="ordinary" type="text" value="${score.ordinary }" />
									</td>
									<td>
										<input name="endterm" type="text" value="${score.endterm }" />
									</td>
									<td>
										<input name="score" type="text" value="${score.score }" />
									</td>
								</tr>							
							</c:forEach>
						</table>
						<div class="col-md-4 col-md-offset-5">
							<button id="submit" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>上传成绩
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>