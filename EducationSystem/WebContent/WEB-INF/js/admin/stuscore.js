$(function() {
	//查看学生成绩页面的事件
	$("#stuscoreSearch").submit(function() {
		if($("#studentid").val() == "") { //若没有填写学号
			alert("请填写需要查询的学生学号！");
			return false;
		} else {
			return true;
		}
	});	
	
	
	
	
	
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

	//针对不同操作更改提交的url地址
	var manageResult = $("#manageResult").val();
	if(manageResult == 1) { //进行添加操作
		$("#elective").attr("action", "adminInsertElective");
	} else if(manageResult == 2) { //进行删除操作
		$("#elective").attr("action", "adminDeleteElective");
	} else if(manageResult == 3) { //进行修改操作
		$("#elective").attr("action", "adminModifyElective");
	}
	
	$("#electiveResult").submit(function() {		
		var str = "";
		var i = 0;
		//遍历所有的选修课
		$("tr").each(function(){
			if ($(this).children("td").children("div").children(".select").prop("checked")) { //若该选择框已经选择
				//获取编号并进行拼接
				var id = $(this).children("#id").html();
				str = str+id+"*";
				i++;
			}
		});		
		if (i>0) { //有进行选择
			//拼接起来的id字符串赋值给输入框
			var ids = str;
			$("#result").val(ids);
			if(confirm("确定提交该课程的信息？")) {
				alert("提交成功！");
				return false;
			} else {
				return false;
			}			
		} else{ //没有进行选择
			alert("请进行选择！");
			return false;
		}
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
			//清空选择
			$(this).next("#selectBox").html("");
			//标记该选修课
			$(this).parents("tr").attr("class","success");
		}
	});	
});