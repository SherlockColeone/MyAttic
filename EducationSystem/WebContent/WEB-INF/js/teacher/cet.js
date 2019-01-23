$(function() {
	$("button").click(function(){
		if ($(".id").val()=="") {
			alert("请输入需要查询的学号！");
			return false;
		}
	});
});