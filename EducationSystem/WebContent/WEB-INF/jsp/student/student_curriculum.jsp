<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生课程表</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/student_curriculum.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/curriculum.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-8 col-md-offset-2">
					<center>
						<h4>学期课程表</h4>
					</center>
				</div>
				<div id="buttonGroup" class="col-md-10 col-md-offset-2">
					<form action="${pageContext.servletContext.contextPath}/studentSearchCurriculum" method="post">
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
				</div>
				<div id="hidden" hidden>
					<c:forEach items="${resultList }" var="curr">
						<div>
							<span>${curr.day }</span>
							<div>${curr.lesson }</div>
							<p>
								${curr.name }<br>
								任课老师：${curr.teacher }<br>
								${curr.week }<br>
								${curr.time }节<br>
								地点：${curr.place }
							</p>
						</div>
					</c:forEach>
				</div>				
				<div class="col-md-12">
					<table class="table table-striped">
						<tr>
							<td></td>
							<td>星期一</td>
							<td>星期二</td>
							<td>星期三</td>
							<td>星期四</td>
							<td>星期五</td>
							<td>星期六</td>
							<td>星期日</td>
						</tr>
						<tr>
							<td>
								一<br />
								1-2节
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>
								二<br />
								3-4节
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="8">中午</td>
						</tr>
						<tr>
							<td>
								三<br />
								5-6节
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>
								四<br />
								7-8节
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="8">晚上</td>
						</tr>						
						<tr>
							<td>
								五<br />
								9-10节
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>						
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>