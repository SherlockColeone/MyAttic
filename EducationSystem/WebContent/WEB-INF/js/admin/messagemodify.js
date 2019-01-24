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
});