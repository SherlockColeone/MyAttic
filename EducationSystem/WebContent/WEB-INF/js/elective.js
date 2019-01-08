/**
 * 选课的js事件
 */

$(function() {
	$(".apply").click(function() {
		$("#showId").html("");
		$("#showName").html("");
		$("#showTeacher").html("");
		$("#showTime").html("");
		$("#single").css("display", "block");
		var id = $(this).parents("tr").children(".id").html();
		var name = $(this).parents("tr").children(".name").html();
		var teacher = $(this).parents("tr").children(".teacher").html();		
		var time = $(this).parents("tr").children(".time").html();
		$("#showId").html(id);
		$("#id").val(id);
		$("#showName").html(name);
		$("#showTeacher").html(teacher);
		$("#showTime").html(time);		
	});

	$("#submit").click(function() {
		if(confirm("确定选择该选修课？")) {
			alert("选择成功！");
			$("form").attr("action", "${pageContext.servletContext.contextPath}/studentApplyCet/" + $("#id").val());
			$("form").submit();
		} else {
			return false;
		}
	});
});