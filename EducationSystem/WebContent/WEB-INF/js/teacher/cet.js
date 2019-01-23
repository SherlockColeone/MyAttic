/**
 * 教师社会考试管理页面的js文件
 */

$(function() {
	$("button").click(function(){
		if ($(".id").val()=="") {
			alert("请输入需要查询的学号！");
			return false;
		}
	});
});