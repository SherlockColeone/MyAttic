$(function() {
	$("#upload").submit(function() {
		var str = "";
		//遍历所有的成绩
		$("tr").each(function() {
			var studentid = $(this).children("td").children("#studentid").val();
			var score = $(this).children("td").children("#score").val();
			str = str + studentid + "^" + score + "*";
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