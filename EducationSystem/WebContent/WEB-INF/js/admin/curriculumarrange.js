$(function(){
	//该方法用于显示日期
	var arrangeDate = $("#arrangeDate").html();
	arrangeDate.replace(" ","<br />");
	$("#arrangeDate").html(arrangeDate);
	
	$("#curriculumarrangeSearch").submit(function() {
		if($("#teacherid").val() == "") { //若没有填写工号
			alert("请填写需要操作的教师工号！");
			return false;
		} else {
			return true;
		}
	});
	
	$("#searchCurriculumarrange").submit(function() {
		if($(".operate[type=radio]:checked").size() < 1) { //若没有选择操作
			alert("请选择操作！");
			return false;
		} else if($(".operate[type=radio]:checked").val() == 1) { //选择添加时不需填写编号
			return true;
		} else { //已选择删除或修改
			if($("#inputId").val() == "") { //若没有填写工号
				alert("请填写需要操作的教师工号！");
				return false;
			} else {
				return true;
			}
		}
	});
});
