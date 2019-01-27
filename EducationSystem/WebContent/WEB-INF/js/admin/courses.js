$(function() {
	$("#searchCurriculum").submit(function() {
		if($(".operate[type=radio]:checked").size() < 1) { //若没有选择操作
			alert("请选择操作！");
			return false;
		} else if($(".operate[type=radio]:checked").val() == 1) { //选择添加时不需填写学号或工号
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

	$("#coursesSearchCurriculum").submit(function() {
		if($("#coursesInputId").val() == "") { //若没有填写课程编号
			alert("请填写需要操作的课程编号！");
			return false;
		} else {
			return true;
		}
	});

	//点击当前学期时下拉框选择当前学期
	$("#currentTerm").click(function() {
		//遍历所有学期
		$("#termid").children("option").each(function(index, value) {
			if(value.value == $("#currentTerm").val()) {
				//选中
				$(this).attr("selected", "selected");
			}
		});
	});

	//针对不同操作更改提交的url地址
	var manageResult = $("#manageResult").val();
	if(manageResult == 1) { //进行添加操作
		$("#message").attr("action", "adminInsertCourses");
	} else if(manageResult == 2) { //进行删除操作
		$("#message").attr("action", "adminDeleteCourses");
	} else if(manageResult == 3) { //进行修改操作
		$("#message").attr("action", "adminModifyCourses");
	}

	//点击随机编号时编号输入框的值为0
	$("#randomid").click(function() {
		$("#id").val("0");
	});

	$("#courses").submit(function() {
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
	});
});