package com.zhiyou.clouddisk.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.clouddisk.model.AppUser;
import com.zhiyou.clouddisk.service.AppUserService;

@Controller
public class HelloController {
	@Autowired
	private AppUserService appUserService;
	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("msg", new Date() + "hello");
		return "testhello";//   /WEB-INF/pages/  testhello  .jsp
	}
	//测试从数据库中查询信息，展示到页面上
	@RequestMapping("/users")
	public String showUser(Model model){
		//调用service层获取数据
		List<AppUser> users = appUserService.getAppUsers();
		model.addAttribute("users", users);
		return "testusers";
	}
}
