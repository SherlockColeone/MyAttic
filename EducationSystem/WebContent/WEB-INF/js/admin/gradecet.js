$(function() {
	$("#cetSubmit").click(function(){
		if ($(".id").val()=="") {
			alert("请输入需要查询的学号！");
			return false;
		}
	});	
	
	
	
	
	
	
	//查看学生成绩页面的事件
	$("#stuscoreSearch").submit(function() {
		if($("#studentid").val() == "") { //若没有填写学号
			alert("请填写需要查询的学生学号！");
			return false;
		} else {
			return true;
		}
	});	
	
	$("#classesSearch").submit(function() {
		if($("#classesid").val() == "") { //若没有填写学号
			alert("请填写需要查询的班级编号！");
			return false;
		} else {
			return true;
		}
	});
	
	//全选/全不选框
	$("#checkAll").change(function(){
		if ($(this).prop("checked")) { //若是全选
			//遍历所有选择框
			$(".select").each(function(){
				$(this).prop("checked","checked");
			});			
		}
	});	
	
	//遍历输入框
	$(".hide").each(function(index,value) {
		if (value.value==0) { //证明该专业课尚未添加			
			$(this).next("div").attr("display","block");
		} else if(value.value==1){ //证明该专业课已经添加
			//清空选择
			$(this).next("#selectBox").html("");
			//标记该专业课
			$(this).parents("tr").attr("class","success");
		}
	});
	
	$("#coursesResult").submit(function() {
		var str = "";
		var i = 0;
		//遍历所有的专业课
		$("tr").each(function(){
			if ($(this).children("td").children("div").children(".select").prop("checked")) { //若该选择框已经选择
				//获取编号并进行拼接
				var id = $(this).children("#id").html();
				str = str+id+"*";
				i++;
			}
		});		
		if (i>0) { //有进行选择
			//拼接起来的id字符串赋值给输入框
			var ids = str;
			$("#result").val(ids);
			if(confirm("确定录入已选择的专业课？")) {
				alert("录入成功！");
				return true;
			} else {
				return false;
			}			
		} else{ //没有进行选择
			alert("请进行选择！");
			return false;
		}
	});
	
});