/**
 * 管理员考试安排管理的js文件
 */

$(function() {
	//需要将考试时间分割成日期与时间
	var examtime = $("#examtime").val();
	var split = examtime.split(" ");
	for(var index in split) { //分别放到日期与时间的输入框内
		if (index==0) {
			$("#date").val(split[0]);
			$("#dayexam").html(split[0]);
		} else{
			$("#time").val(split[1]);
			$("#timeexam").html(split[1]);
		}		
	}

	$("#examSearchCurriculum").submit(function() {
		if($("#examInputId").val() == "") { //若没有填写课程编号
			alert("请填写需要操作的课程编号！");
			return false;
		} else {
			return true;
		}
	});
	
	$("#searchCurriculum").submit(function() {
		if($(".operate[type=radio]:checked").size() < 1) { //若没有选择操作
			alert("请选择操作！");
			return false;
		} else if($(".operate[type=radio]:checked").val() == 1) { //选择添加时不需填写编号
			return true;
		} else { //已选择删除或修改
			if($("#inputId").val() == "") { //若没有填写课程编号
				alert("请填写需要操作的课程编号！");
				return false;
			} else {
				return true;
			}
		}
	});

	//针对不同操作更改提交的url地址
	var manageResult = $("#manageResult").val();
	if(manageResult == 1) { //进行添加操作
		$("#exam").attr("action", "adminInsertExam");
	} else if(manageResult == 2) { //进行删除操作
		$("#exam").attr("action", "adminDeleteExam");
	} else if(manageResult == 3) { //进行修改操作
		$("#exam").attr("action", "adminModifyExam");
	}

	//点击随机编号时编号输入框的值为0
	$("#randomid").click(function() {
		$("#id").val("0");
	});

	$("#exam").submit(function() {
		if(manageResult == "") { //没有选择操作便提交
			alert("请选择操作再提交课程！");
			return false;
		} else {
			//拼接考试日期与时间
			var dateVal = $("#date").val();
			var time = $("#time").val();
			$("#examtime").val(dateVal + " " + time);
			var i = 0;
			$(".courses").each(function(index, value) {
				if(value.value == "") {
					i++;
				}
			});
			if(i > 0) {
				alert("不能存在空的数据！");
				return false;
			} else if(confirm("确定提交该课程的信息？")) {
				alert("提交成功！");
			} else {
				return false;
			}
		}
	});
});