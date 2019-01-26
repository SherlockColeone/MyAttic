$(function(){
	$("#searchCurriculum").submit(function(){
		if($(".operate[type=radio]:checked").size() < 1) { //若没有选择操作
			alert("请选择操作！");
			return false;
		} else if($(".operate[type=radio]:checked").val()==1){ //选择添加时不需填写学号或工号
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
	
	$("#courses").submit(function(){
		
	});
});
