package com.cn.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	�������Ա�������ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminHomeController {
	
	@RequestMapping(value="/adminHome")
	public String adminHome() {
		//��ת������Ա��������
		return "admin/admin_home";
	}
	
}
