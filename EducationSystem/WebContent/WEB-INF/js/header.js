$(function(){
	//更改颜色
	//浅绿色
	$("#DarkSeaGreen").click(function(){
		$(".btn").css("background-color","DarkSeaGreen");
		$(".btn").css("color","navy");
		$("#navigator").css("background-color","DarkSeaGreen");
		$(".nav>li>a").css("color","navy");
	});
	
	//天蓝色
	$("#SkyBlue").click(function(){
		$(".btn").css("background-color","SkyBlue");
		$(".btn").css("color","black");
		$("#navigator").css("background-color","SkyBlue");
		$(".nav>li>a").css("color","black");		
	});
	
	//黑色
	$("#Black").click(function(){
		$(".btn").css("background-color","black");
		$(".btn").css("color","silver");
		$("#navigator").css("background-color","black");
		$(".nav>li>a").css("color","silver");			
	});
	
});
