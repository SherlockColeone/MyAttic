package com.cn.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	进入管理员个人中心的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminHomeController {
	
	@RequestMapping(value="/adminHome")
	public String adminHome() {
		//跳转到管理员个人中心
		return "admin/admin_home";
	}
	
}
