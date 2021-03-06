$(function() {
	$(".cetSubmit").click(function(){
		if ($(this).parent(".apply").prev("td").children(".id").val()=="") {
			alert("请输入需要查询的学号！");
			return false;
		}
	});
	
	//查询出考号后显示出修改的选项
	if ($("#studentid").val()!="") {
		$("#result").css("display","block");
	}
	
	$("#cet").submit(function(){
		if ($("#studentid").val()!="") {  //只有当查询之后才能修改
			if ($("#place").val()=="") {
				alert("考试地点不能为空！");
				return false;
			}
			else{
				if(confirm("确定提交该考生的社会考试安排？")) {
					alert("提交成功！");
					return true;
				} else {
					return false;
				}			
			}			
		}
		else{
			alert("必须先查询进行管理的考生号！");
			return false;
		}
	});
	
	//下拉框的默认值问题
	$("option").each(function() {
		var defaultValue = $(this).parent("select").next("input");
		if($(this).val() == defaultValue.val()) {
			$(this).attr("selected", "selected");
		}
	});
});