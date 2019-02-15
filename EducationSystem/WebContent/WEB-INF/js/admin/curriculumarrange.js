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
});
