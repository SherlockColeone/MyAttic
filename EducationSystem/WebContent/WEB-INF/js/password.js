/**
 * password的js文件
 */

$(function() {
	$("#submit").click(function() {
		$("#warnPwd").html(""); //清空警告内容
		$("#warnNewPwd").html("");
		$("#warnRePwd").html("");
		//验证两次新密码是否一致
		var newPwd = $("#newPwd").val();
		var rePwd = $("#rePwd").val();

		if($("#password").val() == null || $("#password").val() == "") {
			$("#warnPwd").html("原始密码不能为空！");
			return false;
		}
		if(newPwd == null || newPwd == "") {
			$("#warnNewPwd").html("新密码不能为空！");
			$("#warnNewPwd").css("display", "inline");
			return false;
		}
		if(rePwd == null || rePwd == "") {
			$("#warnRePwd").html("确认新密码不能为空！");
			$("#warnRePwd").css("display", "inline");
			return false;
		}
		if(newPwd != rePwd) { //新密码与确认密码的问题
			var pwdRegex = /^\w{6,20}$/; //密码的正则表达式
			var isRight = newPwd.match(pwdRegex);
			if(isRight) { //判断格式是否正确
				//两次密码不一致
				$("#warnRePwd").css("display", "inline");
				$("#warnRePwd").html("两次密码不一致!");
				return false;
			} else {
				//新密码格式错误
				$("#warnNewPwd").html("密码格式错误，请用大小写英文字母、数字，长度为6-20个字符");
				$("#warnNewPwd").css("display", "inline");
				return false;
			}
		} else { //一致

		}
	});
});