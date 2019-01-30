/**
 * 课程表的js文件
 */

$(function() {
	//获取隐藏的数据
	$("#hidden>div").each(function() {
		//星期几
		var day = $(this).find("span").html();
		//第几大节
		var lesson = $(this).find("div").html();
		if(lesson == 3 || lesson == 4) {
			lesson++;
		}
		if(lesson == 5) {
			lesson = parseInt(lesson);
			lesson = lesson + 2;
		}
		var curr = $(this).find("p").html();
		$("tr").eq(lesson).children("td").eq(day).html(curr);
	});
	
	//管理员课程表的事件
	$("#curriculum").submit(function() {
		if($("#inputId").val() == "") { //若没有填写班级编号
			alert("请填写需要查询的班级编号！");
			return false;
		} else {
			return true;
		}
	});	
});