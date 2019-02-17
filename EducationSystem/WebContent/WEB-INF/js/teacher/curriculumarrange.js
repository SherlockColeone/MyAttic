$(function(){
	//该方法用于显示日期
	var arrangeDate = $("#arrangeDate").html();
	arrangeDate.replace(" ","<br />");
	$("#arrangeDate").html(arrangeDate);
	
	//下拉框的默认值问题
	$("option").each(function() {
		var defaultValue = $(this).parent("select").prev(".define");
		if($(this).val() == defaultValue.val()) {
			$(this).attr("selected", "selected");
		}
	});
	
	
});
