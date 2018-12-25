<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>header</title>

		<style>
			.container {
				margin-top: 8px;
			}
			
			.btn {
				background-color: DarkSeaGreen;
				color: navy;
			}
			
			.dropdown-menu li {
				margin-top: 5px;
			}
			
			#DarkSeaGreen {
				background-color: DarkSeaGreen;
				color: navy;
			}
			
			#SkyBlue {
				background-color: skyblue;
				color: black;
			}
			
			#Black {
				background-color: black;
				color: silver;
			}
			
			.navbar-nav {
				float: none;
				text-align: center;
			}
			
			#navigator {
				background-color: DarkSeaGreen;
			}
			
			li {
				float: none;
				display: inline-block;
				margin-left: 20px;
			}
			
			li a {
				color: navy;
				font-size: 15px;
			}
		</style>

		<script>
			$(function() {
				//更改颜色
				//浅绿色
				$("#DarkSeaGreen").click(function() {
					$(".btn").css("background-color", "DarkSeaGreen");
					$(".btn").css("color", "navy");
					$("#navigator").css("background-color", "DarkSeaGreen");
					$(".nav>li>a").css("color", "navy");
				});

				//天蓝色
				$("#SkyBlue").click(function() {
					$(".btn").css("background-color", "SkyBlue");
					$(".btn").css("color", "black");
					$("#navigator").css("background-color", "SkyBlue");
					$(".nav>li>a").css("color", "black");
				});

				//黑色
				$("#Black").click(function() {
					$(".btn").css("background-color", "black");
					$(".btn").css("color", "silver");
					$("#navigator").css("background-color", "black");
					$(".nav>li>a").css("color", "silver");
				});

			});
		</script>
	</head>

	<body>
		<div class="container col-md-12">
			<div id="top" class="col-md-10 col-lg-offset-2">
				<div class="col-md-6">
					<img src="../../images/logo.png" />
				</div>
				<div id="topRight" class="col-md-offset-6">
					<div class="col-md-10">
						<div class="col-md-6">
							欢迎回来！周星星同学！
						</div>
						<div id="group" class="col-md-6">
							<div class="col-md-6 btn-group">
								<button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
									更改样式
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a id="DarkSeaGreen">浅绿色</a>
									</li>
									<li>
										<a id="SkyBlue">天蓝色</a>
									</li>
									<li>
										<a id="Black">黑&nbsp;&nbsp;&nbsp;&nbsp;色</a>
									</li>
								</ul>
							</div>
							<div class="col-md-6">
								<a href="#" id="quit" class="btn" role="button">注销</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--导航栏-->
			<div id="navigator" class="col-md-12">
				<div class="col-md-offset-3">
					<!-- 导航条中的导航组件 -->
					<ul class="nav navbar-nav">
						<li>
							<a href="首页index.html">首页</a>
						</li>
						<li>
							<a href="产品列表list.html">个人信息</a>
						</li>
						<li>
							<a href="手机phone.html">课程安排</a>
						</li>
						<li>
							<a href="电脑pc.html">学生成绩</a>
						</li>
						<li>
							<a href="#">考试安排</a>
						</li>
						<li>
							<a href="#">选课中心</a>
						</li>
						<li>
							<a href="#">其他</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>