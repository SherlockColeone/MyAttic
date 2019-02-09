<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>班级专业课录入</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/stuscore.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<div class="col-md-3">
						<a href="${pageContext.servletContext.contextPath}/adminStuscore" class="btn btn-default">
							<span class="glyphicon glyphicon-arrow-left"></span>查看学生成绩页面
						</a>
					</div>
				</div>
				<div class="col-md-offset-5">
					<h4>班级专业课录入</h4>
				</div>				
				<div id="buttonGroup" class="col-md-12 col-md-offset-3">
					<form id="classesSearch" action="${pageContext.servletContext.contextPath}/adminStuscoreCheckClassess" method="post">
						<div id="classes" class="col-md-4">
							班级编号：<input id="classesid" type="text" name="classesid" />
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询班级
							</button>
						</div>
					</form>
				</div>
				<div>${classesName }本学期的所有专业课：</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<form id="coursesResult" action="${pageContext.servletContext.contextPath}/adminAddStuscore" method="post">
							<table class="table table-condensed">
								<tr>
									<td>
										<label for="checkAll">全选&nbsp;</label><input type="radio" id="checkAll" />
									</td>
									<td>专业课编号</td>
									<td>课程名称</td>
									<td>开课时间</td>
									<td>课程教师编号</td>
									<td>课程教师姓名</td>
									<td>上课时间</td>
									<td>上课地点</td>
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
								</tr>								
								</c:forEach>
							</table>
							<!--用于拼接所有已选择的专业课id与班级id-->
							<input id="result" name="result" value="" hidden="hidden" readonly="readonly" />							
							<input id="classesid" name="classesid" value="${classesid }" hidden="hidden" readonly="readonly" />
							<div class="col-md-12 col-md-offset-5">
								<button id="submit" type="submit" class="btn btn-info">
									<span class="glyphicon glyphicon-check"></span>录入已选择的专业课
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