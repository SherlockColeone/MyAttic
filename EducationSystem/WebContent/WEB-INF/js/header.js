/**
 * header的js文件
 */

$(function() {
	//更改颜色
	//浅绿色
	$("#DarkSeaGreen").click(function() {
		$(".change").css("background-color", "DarkSeaGreen");
		$(".change").css("color", "navy");
	});

	//天蓝色
	$("#SkyBlue").click(function() {
		$(".change").css("background-color", "SkyBlue");
		$(".change").css("color", "black");
	});

	//黑色
	$("#Black").click(function() {
		$(".change").css("background-color", "black");
		$(".change").css("color", "silver");
	});
	
	//注销确认事件
	$("#quit").click(function() {
		if(confirm("确定注销账户？")){
			location.href = "quit";
		}
		else{
			return false;
		}
	});

});