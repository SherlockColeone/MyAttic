<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看学生选课结果</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/elective.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="col-md-3">
					<a href="${pageContext.servletContext.contextPath}/adminElectiveModify" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>前往选课管理
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>查看学生选课结果</h4>
				</div>
				<div class="col-md-12">
					本学期所有选修课名单如下：（绿色标记的是已经添加的课程）
				</div>
				<div class="col-md-12">					
					<div class="col-md-12">
						<form id="electiveResult" action="${pageContext.servletContext.contextPath}/adminAddElective" method="post">
							<table class="table table-condensed">
								<tr>
									<td>
										<label for="checkAll">全选&nbsp;</label><input type="radio" name="check" id="checkAll" />
										<label for="dontCheck">全不选&nbsp;</label><input type="radio" name="check" id="dontCheck" />
									</td>
									<td>选修课编号</td>
									<td>选修课名称</td>
									<td>开课时间</td>
									<td>课程教师编号</td>
									<td>课程教师姓名</td>
									<td>上课时间</td>
									<td>上课地点</td>
									<td>课程人数</td>
								</tr>
								<c:forEach items="${list }" var="bean">
								<tr>
									<td>
										<input class="hide" value="${bean.isInserted }" hidden="hidden" readonly="readonly" />
										<div id="selectBox">
											选择&nbsp;<input type="checkbox" class="select" />
										</div>
									</td>
									<td id="id">${bean.id }</td>
									<td>${bean.name }</td>
									<td>${bean.week }</td>
									<td>${bean.teacherid }</td>
									<td>${bean.teacher }</td>
									<td>${bean.time }</td>
									<td>${bean.place }</td>
									<td>${bean.number }</td>
								</tr>									
								</c:forEach>								
							</table>
							<!--用于拼接所有已选择的选课id-->
							<input id="result" name="result" value="" hidden="hidden" readonly="readonly" />							
							<div class="col-md-12 col-md-offset-5">
								<button id="submit" type="submit" class="btn btn-info">
									<span class="glyphicon glyphicon-check"></span>添加已选择的课程
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