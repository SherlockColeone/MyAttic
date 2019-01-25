$(function() {
	//下拉框的值产生变化，身份产生变化
	$("#identity").change(function() {
		//选择学生身份时
		if($("select option:selected").val() == 3) {
			$(".idLabel").html("学号:");
		}
		//选择教师身份时
		else if($("select option:selected").val() == 2) {
			$(".idLabel").html("工号:");
		}
		//选择管理员身份时
		else {
			$(".idLabel").html("工号:");
		}
	});

	//针对不同的身份对表格进行更改
	var identityResult = $("#identityResult").val();
	if(identityResult == 3) { //进行操作的是学生
		
	} else if(identityResult == 2) { //进行操作的是教师
		//隐藏学生表格，显示教师表格
		$("#forTeacher").css("display", "block");
		$("#forStudent").css("display", "none");
	} else if(identityResult == 1) { //进行操作的是管理员
		$("#forAdmin").css("display", "block");
		$("#forStudent").css("display", "none");
	}
	
	//针对不同操作更改提交的url地址
	var manageResult = $("#manageResult").val();
	if(manageResult == 1) { //进行添加操作
		$("#message").attr("action", "${pageContext.servletContext.contextPath}/adminInsertMessage");
	} else if(manageResult == 2) { //进行删除操作
		$("#message").attr("action", "${pageContext.servletContext.contextPath}/adminDeleteMessage");
	} else if(manageResult == 3) { //进行修改操作
		$("#message").attr("action", "${pageContext.servletContext.contextPath}/adminModifyMessage");
	}

	//判断是否存在空的信息
	var checkNull = function() {
		if(identityResult == 3) { //进行操作的是学生
			var i = 0;
			//遍历所有的输入框
			$("#forStudent .input").each(function(index, value) {
				if(value.value == "") {
					//若存在未输入的值，返回false
					i++;
				}
			});
			$("#forStudent .longInput").each(function(index, value) {
				if(value.value == "") {
					i++;
				}
			});
			if (i!=0) {
				
			} else{
				return true;
			}			
		} else if(identityResult == 2) { //进行操作的是教师
			var i = 0;
			$("#forTeacher .input").each(function(index, value) {
				if(value.value == "") {
					//若存在未输入的值，返回false
					i++;
				}
			});
			$("#forTeacher .longInput").each(function(index, value) {
				if(value.value == "") {
					i++;
				}
			});
			if (i!=0) {
				
			} else{
				return true;
			}	
		} else if(identityResult == 1) { //进行操作的是管理员
			var i = 0;			
			$("#forAdmin .input").each(function(index, value) {
				if(value.value == "") {
					//若存在未输入的值，返回false
					i++;
				}
			});
			$("#forAdmin .longInput").each(function(index, value) {
				if(value.value == "") {
					i++;
				}
			});
			if (i!=0) {
				
			} else{
				return true;
			}
		}
	}

	$("#message").submit(function() {
		if(checkNull()) {
			if(confirm("确定提交该用户的个人信息？")) {
				alert("提交成功！");
			} else {
				return false;
			}
		} else {
			alert("存在未写入的值！");
			return false;
		}
	});
});