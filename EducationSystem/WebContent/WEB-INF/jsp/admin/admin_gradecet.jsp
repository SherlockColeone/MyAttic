<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>教师评价结果</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<link rel="stylesheet" href="css/courses.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/teacher/evaluation.js"></script>
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
					<div id="content" hidden="hidden">
						<c:forEach items="${list }" var="result">
							<span>${result.item }</span>
						</c:forEach>
					</div>				
					<div class="col-md-5">
						当前评价的教师：${teacher.name }<br />
						已有 ${sum } 人对该教师作出评价，评价人数及比例如下：
					</div>
					<div id="form" class="col-md-12">
						<div id="i0" class="col-md-12">
							<h5>1、任课老师在教学中是否保持精神饱满，仪表端庄，声音洪亮</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i1" class="col-md-12">
							<h5>2、任课教师专业知识方面</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i2" class="col-md-12">
							<h5>3、您认为任课教师在及时更新教学内容，介绍学科新动态、新发展、理论联系实际方面做得如何</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i3" class="col-md-12">
							<h5>4、您认为老师在教学中是否善于启发学生思维，培养学生的动手能力</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i4" class="col-md-12">
							<h5>5、您认为任课老师在课堂教学中能否做到突出重点，化解难点，讲授熟练，清晰透彻</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i5" class="col-md-12">
							<h5>6、您认为任课老师是否因材施教，注重学生学习方法的引导</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i6" class="col-md-12">
							<h5>7、您认为在课堂上，任课老师与同学的互动情况</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i7" class="col-md-12">
							<h5>8、您认为课堂上的学习气氛如何</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i8" class="col-md-12">
							<h5>9、您认为该老师的语言表达能力如何</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
						<div id="i9" class="col-md-12">
							<h5>10、该老师布置作业的情况如何</h5>
							<div class="col-md-3">
								<label>非常好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较好</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>一般</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>较差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>

							<div class="col-md-3">
								<label>非常差</label>
							</div>
							<div class="col-md-9">
								<label class="result"></label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>