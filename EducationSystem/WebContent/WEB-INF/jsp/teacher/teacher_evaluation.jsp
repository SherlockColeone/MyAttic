<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师评价结果</title>
		<link rel="stylesheet" href="../css/bootstrap.css" />
		<link rel="stylesheet" href="../css/bootstrap-theme.css" />
		<link rel="stylesheet" href="../css/courses.css" />
		<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/evaluation.js"></script>
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<!--主体-->
		<div id="main" class="container col-md-12">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-offset-5">
					<h4>教师评价结果</h4>
				</div>
				<div class="col-md-12">
					<div class="col-md-5">
						当前评价的教师：${teacherName }
					</div>
					<div id="form" class="col-md-12">
						<form action="${pageContext.servletContext.contextPath}/studentEvaluationSubmit" method="post">
							<div hidden><input name="teacherid" value="${teacherid }"/></div>
							<div class="col-md-12">
								<h5>1、任课老师在教学中是否保持精神饱满，仪表端庄，声音洪亮</h5>
								<div>
									<input id="first-1" type="radio" value="1" name="first" />
									<label for="first-1">非常好</label>
								</div>
								<div>
									<input id="first-2"  type="radio" value="2" name="first" />
									<label for="first-2">较好</label>
								</div>
								<div>
									<input id="first-3" type="radio" value="3" name="first" />
									<label for="first-3">一般</label>
								</div>
								<div>
									<input id="first-4" type="radio" value="4" name="first" />
									<label for="first-4">较差</label>
								</div>
								<div>
									<input id="first-5" type="radio" value="5" name="first" />
									<label for="first-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>2、任课教师专业知识方面</h5>
								<div>
									<input id="second-1" type="radio" value="1" name="second" />
									<label for="second-1">非常好</label>
								</div>
								<div>
									<input id="second-2"  type="radio" value="2" name="second" />
									<label for="second-2">较好</label>
								</div>
								<div>
									<input id="second-3" type="radio" value="3" name="second" />
									<label for="second-3">一般</label>
								</div>
								<div>
									<input id="second-4" type="radio" value="4" name="second" />
									<label for="second-4">较差</label>
								</div>
								<div>
									<input id="second-5" type="radio" value="5" name="second" />
									<label for="second-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>3、您认为任课教师在及时更新教学内容，介绍学科新动态、新发展、理论联系实际方面做得如何</h5>
								<div>
									<input id="third-1" type="radio" value="1" name="third" />
									<label for="third-1">非常好</label>
								</div>
								<div>
									<input id="third-2"  type="radio" value="2" name="third" />
									<label for="third-2">较好</label>
								</div>
								<div>
									<input id="third-3" type="radio" value="3" name="third" />
									<label for="third-3">一般</label>
								</div>
								<div>
									<input id="third-4" type="radio" value="4" name="third" />
									<label for="third-4">较差</label>
								</div>
								<div>
									<input id="third-5" type="radio" value="5" name="third" />
									<label for="third-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>4、您认为老师在教学中是否善于启发学生思维，培养学生的动手能力</h5>
								<div>
									<input id="fourth-1" type="radio" value="1" name="fourth" />
									<label for="fourth-1">非常好</label>
								</div>
								<div>
									<input id="fourth-2"  type="radio" value="2" name="fourth" />
									<label for="fourth-2">较好</label>
								</div>
								<div>
									<input id="fourth-3" type="radio" value="3" name="fourth" />
									<label for="fourth-3">一般</label>
								</div>
								<div>
									<input id="fourth-4" type="radio" value="4" name="fourth" />
									<label for="fourth-4">较差</label>
								</div>
								<div>
									<input id="fourth-5" type="radio" value="5" name="fourth" />
									<label for="fourth-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>5、您认为任课老师在课堂教学中能否做到突出重点，化解难点，讲授熟练，清晰透彻</h5>
								<div>
									<input id="fifth-1" type="radio" value="1" name="fifth" />
									<label for="fifth-1">非常好</label>
								</div>
								<div>
									<input id="fifth-2"  type="radio" value="2" name="fifth" />
									<label for="fifth-2">较好</label>
								</div>
								<div>
									<input id="fifth-3" type="radio" value="3" name="fifth" />
									<label for="fifth-3">一般</label>
								</div>
								<div>
									<input id="fifth-4" type="radio" value="4" name="fifth" />
									<label for="fifth-4">较差</label>
								</div>
								<div>
									<input id="fifth-5" type="radio" value="5" name="fifth" />
									<label for="fifth-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>6、您认为任课老师是否因材施教，注重学生学习方法的引导</h5>
								<div>
									<input id="sixth-1" type="radio" value="1" name="sixth" />
									<label for="sixth-1">非常好</label>
								</div>
								<div>
									<input id="sixth-2"  type="radio" value="2" name="sixth" />
									<label for="sixth-2">较好</label>
								</div>
								<div>
									<input id="sixth-3" type="radio" value="3" name="sixth" />
									<label for="sixth-3">一般</label>
								</div>
								<div>
									<input id="sixth-4" type="radio" value="4" name="sixth" />
									<label for="sixth-4">较差</label>
								</div>
								<div>
									<input id="sixth-5" type="radio" value="5" name="sixth" />
									<label for="sixth-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>7、您认为在课堂上，任课老师与同学的互动情况</h5>
								<div>
									<input id="seventh-1" type="radio" value="1" name="seventh" />
									<label for="seventh-1">非常好</label>
								</div>
								<div>
									<input id="seventh-2"  type="radio" value="2" name="seventh" />
									<label for="seventh-2">较好</label>
								</div>
								<div>
									<input id="seventh-3" type="radio" value="3" name="seventh" />
									<label for="seventh-3">一般</label>
								</div>
								<div>
									<input id="seventh-4" type="radio" value="4" name="seventh" />
									<label for="seventh-4">较差</label>
								</div>
								<div>
									<input id="seventh-5" type="radio" value="5" name="seventh" />
									<label for="seventh-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>8、您认为课堂上的学习气氛如何</h5>
								<div>
									<input id="eighth-1" type="radio" value="1" name="eighth" />
									<label for="eighth-1">非常好</label>
								</div>
								<div>
									<input id="eighth-2"  type="radio" value="2" name="eighth" />
									<label for="eighth-2">较好</label>
								</div>
								<div>
									<input id="eighth-3" type="radio" value="3" name="eighth" />
									<label for="eighth-3">一般</label>
								</div>
								<div>
									<input id="eighth-4" type="radio" value="4" name="eighth" />
									<label for="eighth-4">较差</label>
								</div>
								<div>
									<input id="eighth-5" type="radio" value="5" name="eighth" />
									<label for="eighth-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>9、您认为该老师的语言表达能力如何</h5>
								<div>
									<input id="nineth-1" type="radio" value="1" name="nineth" />
									<label for="nineth-1">非常好</label>
								</div>
								<div>
									<input id="nineth-2"  type="radio" value="2" name="nineth" />
									<label for="nineth-2">较好</label>
								</div>
								<div>
									<input id="nineth-3" type="radio" value="3" name="nineth" />
									<label for="nineth-3">一般</label>
								</div>
								<div>
									<input id="nineth-4" type="radio" value="4" name="nineth" />
									<label for="nineth-4">较差</label>
								</div>
								<div>
									<input id="nineth-5" type="radio" value="5" name="nineth" />
									<label for="nineth-5">非常差</label>
								</div>
							</div>
							<div class="col-md-12">
								<h5>10、该老师布置作业的情况如何</h5>
								<div>
									<input id="tenth-1" type="radio" value="1" name="tenth" />
									<label for="tenth-1">非常好</label>
								</div>
								<div>
									<input id="tenth-2"  type="radio" value="2" name="tenth" />
									<label for="tenth-2">较好</label>
								</div>
								<div>
									<input id="tenth-3" type="radio" value="3" name="tenth" />
									<label for="tenth-3">一般</label>
								</div>
								<div>
									<input id="tenth-4" type="radio" value="4" name="tenth" />
									<label for="tenth-4">较差</label>
								</div>
								<div>
									<input id="tenth-5" type="radio" value="5" name="tenth" />
									<label for="tenth-5">非常差</label>
								</div>
							</div>
							<div class="col-md-4 col-md-offset-5">
								<button id="submit" type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-ok"></span>提交
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