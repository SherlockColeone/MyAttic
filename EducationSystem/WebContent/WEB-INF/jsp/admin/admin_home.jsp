<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员个人中心</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/admin/admin_home.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/admin/home.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		
		<!--主体-->
		<div id="main" class="container col-md-12">
			<div id="block" class="col-md-8 col-md-offset-2">
				<button type="button" id="courses" class="col-md-2 btn" style="margin: 5px;">
					<img src="images/courses.png" />
					<div>
						课程安排&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<a href="${pageContext.servletContext.contextPath}/adminCurriculum" id="curriculum" class="col-md-2 btn" style="padding-top: 30px;">
					<img src="images/curriculum.png" />
					<div>课程表</div>
				</a>
				<button type="button" id="message" class="col-md-2 btn" style="margin: 5px;">
					<img src="images/personal.png" />
					<div>
						个人信息中心&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
					<div>工号：2018624</div>
					<div>姓名：陈轩平</div>
					<div>身份：管理员</div>
				</button>
				<button type="button" id="curriculumarrange" class="col-md-2 btn" style="margin: 5px;margin-top: 158px;">
					<img src="images/curriculumarrange.png" />
					<div>
						调课通知&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<button type="button" id="elective" class="col-md-2 btn" style="margin: 5px;">
					<img src="images/elective.png" />
					<div>
						选课管理&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<button type="button" id="stuscore" class="col-md-2 btn" style="padding-top: 30px;margin: 5px;">
					<img src="images/stuscore.png" />
					<div>
						学生成绩管理&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<button type="button" id="password" class="col-md-2 btn" style="padding-top: 30px;margin: 5px;">
					<img src="images/password.png" />
					<div>
						密码管理&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<button type="button" id="exam" class="col-md-2 btn" style="padding-top: 30px;margin: 5px;">
					<img src="images/exam.png" />
					<div>
						考试安排&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<button id="cet" class="col-md-2 btn" style="padding-top: 30px;margin: 5px;">
					<img src="images/cet.png" />
					<div>
						社会考试安排&nbsp;
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
				<button type="button" id="evaluation" class="col-md-2 btn" style="padding-top: 30px;margin: 5px;">
					<img src="images/evaluation.png" />
					<div>
						社会考试成绩管理
						<span class="glyphicon glyphicon-menu-down"></span>
					</div>
				</button>
			</div>
			<!--右侧两选项-->
			<div class="col-md-2" id="items" style="display: none;">
				<a href="#" id="modify" class="col-md-10 btn">
					<img src="images/modify.png" />
					<div class="item"></div>
				</a>
				<a href="#" id="check" class="col-md-10 btn">
					<img src="images/check.png" />
					<div class="item"></div>
				</a>
			</div>
		</div>
		
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>