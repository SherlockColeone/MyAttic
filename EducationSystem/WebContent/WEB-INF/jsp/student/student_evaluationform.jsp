<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生教师评价</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/student/student_courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-4">
					<h4>学生教师评价</h4>
				</div>
				<div class="col-md-12">
					<div class="col-md-5">
						当前评价的教师：
					</div>
					<div id="form" class="col-md-12">
						<form action="#" method="post">
							<div class="col-md-12">
								<h5>1、任课老师在教学中是否保持精神饱满，仪表端庄，声音洪亮</h5>
								<div><input type="radio" value="1" name="first" />非常好</div>
								<div><input type="radio" value="2" name="first" />较好</div>
								<div><input type="radio" value="3" name="first" />一般</div>
								<div><input type="radio" value="4" name="first" />较差</div>
								<div><input type="radio" value="5" name="first" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>2、任课教师专业知识方面</h5>
								<div><input type="radio" value="1" name="second" />非常好</div>
								<div><input type="radio" value="2" name="second" />较好</div>
								<div><input type="radio" value="3" name="second" />一般</div>
								<div><input type="radio" value="4" name="second" />较差</div>
								<div><input type="radio" value="5" name="second" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>3、您认为任课教师在及时更新教学内容，介绍学科新动态、新发展、理论联系实际方面做得如何</h5>
								<div><input type="radio" value="1" name="third" />非常好</div>
								<div><input type="radio" value="2" name="third" />较好</div>
								<div><input type="radio" value="3" name="third" />一般</div>
								<div><input type="radio" value="4" name="third" />较差</div>
								<div><input type="radio" value="5" name="third" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>4、您认为老师在教学中是否善于启发学生思维，培养学生的动手能力</h5>
								<div><input type="radio" value="1" name="fourth" />非常好</div>
								<div><input type="radio" value="2" name="fourth" />较好</div>
								<div><input type="radio" value="3" name="fourth" />一般</div>
								<div><input type="radio" value="4" name="fourth" />较差</div>
								<div><input type="radio" value="5" name="fourth" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>5、您认为任课老师在课堂教学中能否做到突出重点，化解难点，讲授熟练，清晰透彻</h5>
								<div><input type="radio" value="1" name="fifth" />非常好</div>
								<div><input type="radio" value="2" name="fifth" />较好</div>
								<div><input type="radio" value="3" name="fifth" />一般</div>
								<div><input type="radio" value="4" name="fifth" />较差</div>
								<div><input type="radio" value="5" name="fifth" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>6、您认为任课老师是否因材施教，注重学生学习方法的引导</h5>
								<div><input type="radio" value="1" name="sixth" />非常好</div>
								<div><input type="radio" value="2" name="sixth" />较好</div>
								<div><input type="radio" value="3" name="sixth" />一般</div>
								<div><input type="radio" value="4" name="sixth" />较差</div>
								<div><input type="radio" value="5" name="sixth" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>7、您认为在课堂上，任课老师与同学的互动情况</h5>
								<div><input type="radio" value="1" name="seventh" />非常好</div>
								<div><input type="radio" value="2" name="seventh" />较好</div>
								<div><input type="radio" value="3" name="seventh" />一般</div>
								<div><input type="radio" value="4" name="seventh" />较差</div>
								<div><input type="radio" value="5" name="seventh" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>8、您认为课堂上的学习气氛如何</h5>
								<div><input type="radio" value="1" name="eighth" />非常好</div>
								<div><input type="radio" value="2" name="eighth" />较好</div>
								<div><input type="radio" value="3" name="eighth" />一般</div>
								<div><input type="radio" value="4" name="eighth" />较差</div>
								<div><input type="radio" value="5" name="eighth" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>9、您认为该老师的语言表达能力如何</h5>
								<div><input type="radio" value="1" name="nineth" />非常好</div>
								<div><input type="radio" value="2" name="nineth" />较好</div>
								<div><input type="radio" value="3" name="nineth" />一般</div>
								<div><input type="radio" value="4" name="nineth" />较差</div>
								<div><input type="radio" value="5" name="nineth" />非常差</div>
							</div>
							<div class="col-md-12">
								<h5>10、该老师布置作业的情况如何</h5>
								<div><input type="radio" value="1" name="tenth" />非常好</div>
								<div><input type="radio" value="2" name="tenth" />较好</div>
								<div><input type="radio" value="3" name="tenth" />一般</div>
								<div><input type="radio" value="4" name="tenth" />较差</div>
								<div><input type="radio" value="5" name="tenth" />非常差</div>
							</div>
							<div class="col-md-4 col-md-offset-5">
								<button id="submit" type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-ok"></span>
									提交
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