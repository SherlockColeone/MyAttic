/**
 * 社会考试的js文件
 */

$(function() {
	$("#apply").click(function() {
		$("#single").css("display", "block");
	});

	$("#submit").click(function() {
		if(confirm("确定报名该社会考试？")) {
			alert("报名成功！");
			location.href = "student_cet.html";
		} else {
			return false;
		}
	});
});
