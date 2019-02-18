$(function(){
	//该方法用于显示日期
	var arrangeDate = $("#arrangeDate").html();
	if (arrangeDate!=null) {
		arrangeDate.replace(" ","<br />");
		$("#arrangeDate").html(arrangeDate);
	}

	$("#curriculumarrangeSubmit").submit(function(){
		if ($("#nature").val()==1) {   //若选择了选修课且没有填写班级编号则补上0
			if ($("#classesid").val()=="") {
				$("#classesid").val("0");
			}
		}
		var i = 0;
		$(".input").each(function(index,value){
			if (value.value=="") { //若没有填写完整
				i++;
			}			
		});
		if (i>0) {
			alert("存在尚未填写的信息！");
			return false;
		} else if(confirm("确定提交该调课申请？")) {
			alert("提交成功！");
		} else{
			return false;
		}
	});
});
