/**
 * 管理员个人首页的js文件
 */

$(function() {
	var items = $("#items");
	var modify = $("#modify");
	var check = $("#check");
	
	//将其他的图标恢复原形并显示右侧两选项
	var same = function(){
		//将其他的图标恢复原形
		$("button").children("div").children("span").attr("class","glyphicon glyphicon-menu-down");
		//显示右侧两选项
		items.css("display","block");
	}
	
	//个人信息的函数
	$("#message").click(function(){
		//将其他的图标恢复原形并显示右侧两选项
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("师生个人信息管理");
		//更改跳转的控制器
		modify.attr("href","adminMessageManage");
		check.children("div").html("查看管理员个人信息");
		check.attr("href","adminMessage");		
	});
	
	//课程安排的函数
	$("#courses").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("课程安排管理");
		//更改跳转的控制器
		modify.attr("href","adminCourses");
		check.children("div").html("查看课程安排");
		check.attr("href","adminCheckCourses");
	});
		
	//选课管理的函数
	$("#elective").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("选课管理");
		//更改跳转的控制器
		modify.attr("href","adminElective");
		check.children("div").html("查看选课结果");
		check.attr("href","adminCheckElective");
	});
		
	//调课安排的函数
	$("#curriculumarrange").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("调课安排管理");
		//更改跳转的控制器
		modify.attr("href","adminCurriculumarrange");
		check.children("div").html("查看调课安排");
		check.attr("href","adminCheckCurriculumarrange");
	});
			
	//考试安排的函数
	$("#exam").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("调课安排管理");
		//更改跳转的控制器
		modify.attr("href","adminExam");
		check.children("div").html("查看调课安排");
		check.attr("href","adminCheckExam");
	});
				
	//密码管理的函数
	$("#password").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("重置用户密码");
		//更改跳转的控制器
		modify.attr("href","resetPassword");
		check.children("div").html("修改个人密码");
		check.attr("href","password");
	});
					
	//学生成绩的函数
	$("#stuscore").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("学生成绩管理");
		//更改跳转的控制器
		modify.attr("href","adminStuscore");
		check.children("div").html("查询学生成绩");
		check.attr("href","adminCheckStuscore");
	});
						
	//社会考试安排的函数
	$("#cet").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("社会考试安排管理");
		//更改跳转的控制器
		modify.attr("href","adminCet");
		check.children("div").html("查看社会考试安排");
		check.attr("href","adminCheckCet");
	});
							
	//社会考试成绩的函数
	$("#evaluation").click(function(){
		same();
		//更改图标
		$(this).children("div").children("span").attr("class","glyphicon glyphicon-hand-right");
		modify.children("div").html("社会考试成绩管理");
		//更改跳转的控制器
		modify.attr("href","adminGradeCet");
		check.children("div").html("查看社会考试成绩");
		check.attr("href","adminCheckGradeCet");
	});
});