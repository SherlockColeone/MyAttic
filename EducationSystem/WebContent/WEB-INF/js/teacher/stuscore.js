$(function() {
	$("#submit").click(function() {
		if(confirm("确定上传该课程的成绩？")) {
			alert("上传成功！");
			$("form").attr("action","${pageContext.servletContext.contextPath}/teacherModifyStuscore");
			$("form").submit();
		} else {
			return false;
		}
	});
});