/**
 * 学生社会考试页面的js文件
 */

$(function() {
	var qualification = $("tr").children(".qualification").html();
	if(qualification=="否"){
		$("tr").children(".apply").html("——");
	}
	
	$(".apply").click(function() {
		$("#showName").html("");
		$("#showTime").html("");
		$("#single").css("display", "block");
		var name = $(this).parents("tr").children(".name").html();		
		var time = $(this).parents("tr").children(".time").html();
		var cetId = $(this).parents("tr").children(".cetId").html();
		$("#showName").html(name);
		$("#showTime").html(time);
		$("#cetId").val(cetId);
	});

	$("#submit").click(function() {
		if(confirm("确定报名该社会考试？")) {
			alert("报名成功！");
			$("form").attr("action","studentApplyCet/"+$("#cetId").val());
			$("form").submit();	
		} else {
			return false;
		}
	});
});