$(function(){
	//根据身份去改变需要跳转的页面
	var identity = $("#identity").val();
	if (identity==1) {  //当前账户是管理员
		$("#home").attr("href","adminHome");
		$("#message").attr("href","adminMessageManage");
		$("#courses").attr("href","adminCoursesModify");
		$("#stuscore").attr("href","adminStuscoremodify");
		$("#exam").attr("href","adminExam");
		$("#elective").attr("href","adminElectiveModify");
		$("#password").attr("href","resetPassword");
	} else if(identity==2){  //当前账户是教师
		$("#home").attr("href","teacherHome");
		$("#message").attr("href","teacherMessage");
		$("#courses").attr("href","teacherCourses");
		$("#stuscore").attr("href","teacherStuscore");
		$("#exam").attr("href","teacherExam");
		$("#elective").attr("href","teacherElective");
	} else if(identity==3){  //当前账户是学生
		$("#home").attr("href","studentHome");
		$("#message").attr("href","studentMessage");
		$("#courses").attr("href","studentCourses");
		$("#stuscore").attr("href","studentStuscore");
		$("#exam").attr("href","studentExam");
		$("#elective").attr("href","studentElective");
	}
});
