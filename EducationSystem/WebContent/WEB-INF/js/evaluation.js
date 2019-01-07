/**
 * 教师评价的js事件
 */

$(function() {
	$("form").submit(function() {
		if($("input[type=radio]:checked").size() < 10) {
			alert("有尚未完成的问题！");
			return false;
		} else {
			if(confirm("确定提交该教师的评价？")) {
				alert("提交成功！");
			} else {
				return false;
			}
		}
	});
});