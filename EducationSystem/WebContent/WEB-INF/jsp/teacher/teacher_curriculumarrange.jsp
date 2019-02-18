<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看调课通知</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/teacher/curriculumarrange.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<a href="${pageContext.servletContext.contextPath}/teacherModifyCurriculumarrange" class="btn btn-default">
						<span class="glyphicon glyphicon-arrow-left"></span>申请调课
					</a>
				</div>
				<div class="col-md-offset-5">
					<h4>查看调课通知</h4>
				</div>
				<div class="col-md-12">已批准的调课：（开学以来）</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>课程编号</td>
							<td>课程名称</td>
							<td>课程周次</td>
							<td>调课后时间</td>
							<td>调课后地点</td>
							<td>上课班级</td>
							<td>课程性质</td>
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
								<td>${result.name }</td>
								<td>${result.week }</td>
								<td id="arrangeDate">
									${result.date }
								</td>
								<td>${result.place }</td>
								<td>${result.classes }</td>
								<td>
									<c:if test="${result.coursesid==0 }">
										选修课
									</c:if>
									<c:if test="${result.electiveid==0 }">
										专业课
									</c:if>
								</td>
							</tr>								
						</c:forEach>
					</table>
				</div>
				<div class="col-md-12">未批准或不批准的调课：</div>
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td>调课情况</td>
							<td>课程编号</td>
							<td>课程名称</td>
							<td>课程周次</td>
							<td>调课后时间</td>
							<td>调课后地点</td>
							<td>上课班级</td>
							<td>课程性质</td>
						</tr>
						<c:forEach items="${list2 }" var="result">
						<tr>
							<td>
								<c:if test="${result.permit==-1 }">
									不批准
								</c:if>
								<c:if test="${result.permit==0 }">
									未批准
								</c:if>
							</td>
							<td>
								<c:if test="${result.coursesid==0 }">
									${result.electiveid }
								</c:if>
								<c:if test="${result.electiveid==0 }">
									${result.coursesid }
								</c:if>
							<td>${result.name }</td>
							<td>${result.week }</td>
							<td id="arrangeDate">
								${result.date }
							</td>
							<td>${result.place }</td>
							<td>${result.classes }</td>
							<td>
								<c:if test="${result.coursesid==0 }">
									选修课
								</c:if>
								<c:if test="${result.electiveid==0 }">
									专业课
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