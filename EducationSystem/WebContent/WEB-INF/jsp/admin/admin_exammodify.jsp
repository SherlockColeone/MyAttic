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
		<link rel="stylesheet" href="css/admin/admin_courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/exam.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-10 col-md-offset-1">
				<div class="col-md-3">
					<a href="${pageContext.servletContext.contextPath}/adminExam" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>查看考试安排
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>本学期考试安排管理</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="searchCurriculum" action="${pageContext.servletContext.contextPath}/adminCheckExamForModify" method="post">
						<div id="curriculum" class="col-md-4">
							操作：
							<input id="insert" class="operate" type="radio" name="operate" value="1" />
							<label for="insert">添加&nbsp;&nbsp;&nbsp;</label>
							<input id="delete" class="operate" type="radio" name="operate" value="2" />
							<label for="delete">删除&nbsp;&nbsp;&nbsp;</label>
							<input id="modify" class="operate" type="radio" name="operate" value="3" />
							<label for="modify">修改&nbsp;&nbsp;&nbsp;</label>
						</div>
						<div id="term" class="col-md-4">
							考试安排编号：<input id="inputId" type="text" name="inputId" />
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询考试安排
							</button>
						</div>
					</form>
				</div>	
				<div class="col-md-12">
					进行的操作：
					<c:if test="${manageResult==1 }">添加</c:if>
					<c:if test="${manageResult==2 }">删除</c:if>
					<c:if test="${manageResult==3 }">修改</c:if>
					<br />
				</div>							
				<div class="col-md-12">
					<form id="exam" action="#" method="post">
						<input id="manageResult" name="manageResult" value="${manageResult }" type="text" hidden="hidden" readonly="readonly" />
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
								<td>
									<input type="text" id="id" name="id" value="${exam.id }" class="exam" />
									<button id="randomid" class="btn btn-info" name="id" type="button" value="0">随机分配编号</button>
								</td>
								<td>
									<input type="text" name="coursesid" value="${exam.coursesid }" class="exam" />
								</td>
								<td>
									<input id="date" value="" type="text" class="exam" placeholder="XXXX年-XX月-XX日" />
								</td>
								<td>
									<input id="time" value="" type="text" class="exam" placeholder="XX:XX-XX:XX" />
								</td>
								<input id="examtime" name="examtime" value="${exam.examtime }" type="text" hidden="hidden" readonly="readonly" />
								<td>
									<input type="text" name="place" value="${exam.place }" class="exam" />
								</td>
								<td>
									<input type="text" name="classesid" value="${exam.classesid }" class="exam" />
								</td>
								<td>
									<input type="text" name="teacherid" value="${exam.teacherid }" class="exam" />
								</td>
							</tr>
						</table>
						<div id="confirm" class="col-md-10 col-md-offset-5">
							<button id="submit" type="submit" class="btn btn-success">
								<span class="glyphicon glyphicon-check"></span>提交考试安排信息
							</button>
						</div>
					</form>
				</div>
			</div>			
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>