$(function() {
	var code; //在全局定义验证码
	//产生验证码
	function createCode() {
		code = "";
		var codeLength = 4; //验证码的长度
		var checkCode = $("#check");
		var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数
		for(var i = 0; i < codeLength; i++) { //循环操作
			var index = Math.floor(Math.random() * 36); //取得随机数的索引（0~35）
			code += random[index]; //根据索引取得随机数加到code上
		}
		checkCode.text(code); //把code值赋给验证码
	}
	
	//调用该函数
	createCode();
	//把验证码写在区域中
	$("#code").html(code);
	
	//当点击换一张时再次调用
	$(".col-md-9>a").click(function(){
		createCode();
		$("#code").html(code);
	});
	
	//当点击图片时再次调用
	$("#code").click(function(){
		createCode();
		$("#code").html(code);
	});
	
		
	//下拉框的值产生变化，身份产生变化
	$("#identity").change(function(){
		//选择学生身份时
		if($("select option:selected").val()==3){
			//跳转到学生首页
			$("#form").attr("action","studentLogin");
			$("#idLabel").html("学&nbsp;&nbsp;&nbsp;&nbsp;号:");
		}
		//选择教师身份时
		else if($("select option:selected").val()==2){
			//跳转到教师首页
			$("#form").attr("action","teacherLogin");
			$("#idLabel").html("工&nbsp;&nbsp;&nbsp;&nbsp;号:");
		}
		//选择管理员身份时
		else{
			//跳转到管理员首页
			$("#form").attr("action","adminLogin");
			$("#idLabel").html("工&nbsp;&nbsp;&nbsp;&nbsp;号:");
		}
	});
	
	//检查验证码是否填写正确
	$("#submit").click(function(){
		var check = $("#check").val().toLowerCase();
		var code = $("#code").html().toLowerCase();
		if (check==code) { //验证码输入正确
			
		} else{ //验证码输入错误
			alert("验证码输入错误！");
			return false;
			location.href = "index";
		}
	});

});