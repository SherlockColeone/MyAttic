<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社会考试安排管理</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/cet.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<div class="col-md-3">
						<a href="${pageContext.servletContext.contextPath}/adminCheckCet" class="btn btn-default">
							<span class="glyphicon glyphicon-arrow-left"></span>查看社会考试安排页面
						</a>
					</div>
				</div>
				<div class="col-md-offset-5">
					<h4>社会考试安排管理</h4>
				</div>
				<div class="col-md-12">
					<table class="table table-bordered">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>需要查询的学生学号</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${list }" var="cet">
						<form action="${pageContext.servletContext.contextPath}/adminSelectCetByCetidAndStudentidForCet" method="post">
							<tr>
								<td hidden="hidden">
									<input class="cetid" type="text" name="cetid" value="${cet.id}" hidden="hidden" readonly="readonly" />
								</td>
								<td>${cet.cetname}</td>
								<td>${cet.cettime}</td>
								<td>
									<input class="id" type="text" name="studentid" />
								</td>
								<td class="apply">
									<button id="cetSubmit" type="submit" class="btn" style="background-color: white;">查询</button>
								</td>
							</tr>
						</form>
						</c:forEach>
					</table>
				</div>

				<div id="result" class="col-md-12" style="display: none;">
					<div class="col-md-6">
						社会考试名称：CET-6<br /> 社会考试时间：2018-06-16
					</div>
					<div class="col-md-12">
						<form id="cet" action="${pageContext.servletContext.contextPath}/adminModifyCet" method="post">
							<table class="table table-striped">
								<tr>								
									<td>准考证号</td>
									<td>姓名</td>
									<td>社会考试时间</td>
									<td>社会考试地点</td>
								</tr>
								<tr>
									<td>
										${gradecet.studentid }
										<input id="studentid" type="text" name="studentid" value="${gradecet.studentid }" hidden="hidden" readonly="readonly" />
									</td>
									<td>${studentName }</td>
									<td>${gradecet.cettime }</td>
									<td>
										<select id="classroomid" name="classroomid" class="form-control">
											<c:forEach items="${classroomList }" var="classroom">
												<option value="${classroom.id }">${classroom.name }</option>
											</c:forEach>
										</select>
										<input id="place" type="text" name="place" value="${classroom }" hidden="hidden" readonly="readonly" />
									</td>
								</tr>
							</table>
							<div class="col-md-12 col-md-offset-5">
								<button id="submit" type="submit" class="btn btn-success">
									<span class="glyphicon glyphicon-ok"></span>提交社会考试安排
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