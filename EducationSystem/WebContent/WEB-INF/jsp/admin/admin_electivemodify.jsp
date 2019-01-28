<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>选课管理</title>
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
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-3">
					<a href="${pageContext.servletContext.contextPath}/adminElective" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>查看学生课程安排
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>选课管理</h4>
				</div>
				<div id="buttonGroup" class="col-md-12 col-md-offset-1">
					<form id="searchCurriculum" action="${pageContext.servletContext.contextPath}/adminCheckElective" method="post">
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
							选修课编号：<input id="inputId" type="text" name="inputId" />
						</div>
						<div class="col-md-4">
							<button id="search" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>查询课程
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
					<form id="elective" action="#" method="post">
						<input id="manageResult" name="manageResult" value="${manageResult }" type="text" hidden="hidden" readonly="readonly" />
						<div class="col-md-12">
							<table class="table table-striped">
								<tr>
									<td>选修课编号</td>
									<td>选修课名称</td>
									<td>开课时间</td>
									<td>课程教师编号</td>
									<td>课程教师姓名</td>
								</tr>
								<tr>
									<td>
										<input type="text" id="id" name="id" value="${elective.id }" class="courses" />
										<button id="randomid" class="btn btn-info" name="id" type="button" value="0" style="margin-top: 5px;">随机分配编号</button>
									</td>
									<td>
										<input type="text" name="name" value="${elective.name }" class="courses" />
									</td>
									<td>
										<input type="text" name="week" value="${elective.week }" class="courses" />
									</td>
									<td>
										<input type="text" name="teacherid" value="${elective.teacherid }" class="courses" />
									</td>
									<td>
										<input type="text" name="teacher" value="${elective.teacher }" class="courses" />
									</td>
								</tr>
								<br />
							<tr>
								<td>星期几</td>
								<td>第几节</td>
								<td>上课地点</td>
								<td colspan="2">学期</td>
							</tr>
								<tr>
								
									<td>
										<input class="define" value="${elective.day }" hidden="hidden" />
										<select id="day" name="day" class="form-control" class="courses">
											<option value="1">星期一</option>
											<option value="2">星期二</option>
											<option value="3">星期三</option>
											<option value="4">星期四</option>
											<option value="5">星期五</option>
											<option value="6">星期六</option>
											<option value="7">星期日</option>
										</select>
									</td>
									<td>
										<input class="define" value="${elective.time }" hidden="hidden" />
										<select id="time" name="time" class="form-control" class="courses">
											<option value="01-02">01-02节</option>
											<option value="03-04">03-04节</option>
											<option value="05-06">05-06节</option>
											<option value="07-08">07-08节</option>
											<option value="09-10">09-10节</option>
										</select>
									</td>
									<td>
										<input type="text" name="place" value="${elective.place }" class="courses" />
									</td>
									<td>
										<button id="currentTerm" class="btn btn-info" name="termid" type="button" value="currentTermiId">采用当前学期</button>
									</td>	
									<td>
										<input class="define" value="" hidden="hidden" />
										<select id="termid" name="termid" class="form-control" class="courses">
											<c:forEach items="${termList }" var="term">
												<option value="${term.id }">${term.termtime }</option>												
											</c:forEach>
										</select>										
									</td>
								</tr>
							</table>
						</div>
						<div id="confirm" class="col-md-10 col-md-offset-5">
							<button id="submit" type="submit" class="btn btn-success">
								<span class="glyphicon glyphicon-check"></span>提交信息
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>