/**
 * 选课的js事件
 */

$(function() {
	if($("#iselected").val() == 1) {
		//遍历所有隐藏的标记
		$("td").children("input").each(function() {
			if($(this).val() == 0) { //证明该选修课未被选择
				$(this).next().addClass("disabled");
			}
		});
	}

	//点击选择课程时显示详细信息
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
		//显示提交按钮
		$("#submit").css("display", "block");
	});
	//点击查看课程时显示详细信息
	$(".check").click(function() {
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
		//隐藏提交按钮
		$("#submit").css("display", "none");
	});
	//点击提交时的事件
	$("#submit").click(function() {
		if(confirm("确定选择该选修课？")) {
			alert("选择成功！");
			$("form").submit();
		} else {
			return false;
		}
	});
});