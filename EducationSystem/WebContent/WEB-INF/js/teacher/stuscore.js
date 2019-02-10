$(function() {
	$("#upload").submit(function() {
		var str = "";
		var i = 0;
		//遍历所有的成绩
		$(".foreach").each(function() {
			if (i>0) {
				var studentid = $(this).children("td").children("#studentid").val();
				var score = $(this).children("td").children("#score").val();
				if(score==""){ //当没有填写成绩时
					score = 0;
				}				
				str = str + studentid + "^" + score + "*";
			}
			i++;
		});
		//拼接起来的字符串赋值给输入框
		var result = str;
		$("#result").val(result);
		if(confirm("确定上传成绩？")) {
			alert("上传成功！");
			return true;
		} else {
			return false;
		}
	});
});