/**
 * 社会考试的js文件
 */

$(function() {		
	$(".apply").click(function() {
		$("#showName").html("");
		$("#showTime").html("");
		$("#cetId").html("");
		$("#single").css("display", "block");
		var name = $(this).parents("tr").children(".name").html();		
		var time = $(this).parents("tr").children(".time").html();
		var cetId = $(this).parents("tr").children(".cetId").html();
		$("#showName").html(name);
		$("#showTime").html(time);
		$("#cetId").html(cetId);
	});

	$("#submit").click(function() {
		if(confirm("确定报名该社会考试？")) {
			location.href = "studentGradeCet/"+$("#cetId").html();
			alert("报名成功！");		
		} else {
			return false;
		}
	});
});