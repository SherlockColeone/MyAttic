/**
 * 教师评价结果的js事件
 */

$(function() {
	//遍历10道题的所有选择，i对应的是第几题
	for (i=0;i<10;i++) {
		//获取所有的结果
		var content = $("#content").children("span").eq(i).html();
		//把结果分割成5个字符串
		var con = content.split("*");		
		//遍历数组
		$.each(con, function(index,value) {
			//获取单个选项的统计结果value，并放入统计结果中
			$("#i"+i).children("div").children(".result").eq(index).html(value);
		});
	}	
});