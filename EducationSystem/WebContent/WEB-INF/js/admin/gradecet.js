$(function() {
	//点击输入框后显示查询成绩
	$(".id").click(function(){
		$(".cetSubmit").each(function(index,value){
			$(value).css("display","none");
		});
		$(this).next(".btn").css("display","inline-block");
	});
	
	$(".cetSubmit").click(function(){
		if ($(".id").val()=="") {
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
			if ($("#score").val()=="") {
				alert("总成绩不能为空！");
				return false;
			}
			else{
				if(confirm("确定提交该考生的社会考试成绩？")) {
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
});