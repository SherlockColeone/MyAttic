/**
 * 管理员选课管理与查看学生选课结果js事件
 */

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

	$("#electiveSearchCurriculum").submit(function() {
		if($("#electiveInputId").val() == "") { //若没有填写课程编号
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
			} else {
				//其他的撤销选中
				$(this).removeAttr("selected");
			}
		});
	});

	//针对不同操作更改提交的url地址
	var manageResult = $("#manageResult").val();
	if(manageResult == 1) { //进行添加操作
		$("#elective").attr("action", "adminInsertElective");
	} else if(manageResult == 2) { //进行删除操作
		$("#elective").attr("action", "adminDeleteElective");
	} else if(manageResult == 3) { //进行修改操作
		$("#elective").attr("action", "adminModifyElective");
	}

	//点击随机编号时编号输入框的值为0
	$("#randomid").click(function() {
		$("#id").val("0");
	});

	$("#elective").submit(function() {
		if (manageResult=="") { //没有选择操作便提交
			alert("请选择操作再提交课程！");
			return false;
		} else{
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
		
	//下拉框的默认值问题
	$("option").each(function() {
		var defaultValue = $(this).parent("select").prev(".define");
		if($(this).val() == defaultValue.val()) {
			$(this).attr("selected", "selected");
		}
	});
	
	$("#electiveResult").submit(function() {
		
	});
	
	//全选/全不选框
	$("#checkAll").change(function(){
		if ($(this).prop("checked")) { //若是全选
			//遍历所有选择框
			$(".select").each(function(){
				$(this).prop("checked","checked");
			});			
		}
	});
	
	$("#dontCheck").change(function(){
		if ($(this).prop("checked")) { //若是全选
			//遍历所有选择框
			$(".select").each(function(){
				$(this).removeAttr("checked");
			});				
		}
	});	
	
	//遍历输入框
	$(".hide").each(function(index,value) {
		if (value.value==0) { //证明该选修课尚未添加			
			$(this).next("div").attr("display","block");
		} else if(value.value==1){ //证明该选修课已经添加
			//隐藏选择
			$(this).next("div").attr("display","none");
			//标记该选修课
			$(this).parents("tr").attr("class","success");
		}
	});	
});