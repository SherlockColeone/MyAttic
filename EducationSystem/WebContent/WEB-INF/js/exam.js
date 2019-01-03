/**
 * 考试安排的js文件
 */

$(function(){
	//对考试时间的显示进行处理
	var str = $(".time").html();
	var time = str.replace(str.charAt(4),"年");
	time = time.replace(str.charAt(7),"月");
	time = time.replace(str.charAt(10),"日 ");//把一个字符替换成两个字符，"日"后面有空格
	time = time.replace(" ","<br />");
	$(".time").html(time);
});
