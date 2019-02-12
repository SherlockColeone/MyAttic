<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看社会考试成绩</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/gradecet.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

	<body>
		<div id="header"></div>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-12">
					<div class="col-md-3">
						<a href="#" class="btn btn-default">
							<span class="glyphicon glyphicon-arrow-left"></span>社会考试成绩管理页面
						</a>
					</div>
				</div>
				<div class="col-md-offset-5">
					<h4>查看社会考试成绩</h4>
				</div>
				<div class="col-md-12">
					<div>本学期的社会考试：</div>
					<table class="table table-bordered">
						<tr>
							<td>社会考试名称</td>
							<td>社会考试时间</td>
							<td>需要查询的考生号</td>
						</tr>
						<c:forEach items="${list }" var="gradecet">
						
						</c:forEach>						
						<form id="cetSubmit" action="#" method="post">
							<tr>
								<td hidden="hidden">
									<input class="cetid" type="text" name="cetid" value="201864" hidden="hidden" readonly="readonly" />
								</td>
								<td>CET-4</td>
								<td>2018-06-16</td>
								<td>
									<input class="id" type="text" name="id" />
									<button type="submit" class="btn cetSubmit" style="background-color: white;display: none;">查询成绩</button>
								</td>
							</tr>
						</form>
					</table>
				</div>

				<div id="result" class="col-md-12" style="display: none;">
					<div class="col-md-6">
						社会考试名称：CET-6<br /> 社会考试时间：2018-06-16
					</div>
					<div class="col-md-12">
						<table class="table table-striped">
							<tr>
								<td>准考证号</td>
								<td>姓名</td>
								<td>总成绩</td>
							</tr>
							<tr>
								<td>2018620103</td>
								<td>成军局</td>
								<td>425</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>