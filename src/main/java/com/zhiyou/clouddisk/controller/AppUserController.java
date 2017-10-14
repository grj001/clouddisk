package com.zhiyou.clouddisk.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import com.zhiyou.clouddisk.model.AppUser;
import com.zhiyou.clouddisk.model.FileIndex;
import com.zhiyou.clouddisk.service.AppUserService;
import com.zhiyou.clouddisk.service.FileIndexService;

@Controller
@SessionAttributes("user")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private FileIndexService fileIndexService;
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(AppUser appUser){
		appUserService.saveAppUser(appUser);
		return "redirect:login.jsp";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(AppUser appUser,Model model){
		AppUser getAppUser = appUserService.login(appUser);
		
		if(getAppUser!=null && getAppUser.getPassword().equals(appUser.getPassword())){
			model.addAttribute("user", getAppUser);
			//查询根目录下的所有文件显示到主界面去
			List<FileIndex> rootFiles = fileIndexService.getRootFilesByUserId(getAppUser.getUserId());
			model.addAttribute("rootFiles", rootFiles);
			//查询根目录，并且显示到主界面去
			FileIndex rootDir = fileIndexService.getRootDirByUserId(getAppUser.getUserId());
			model.addAttribute("rootDir", rootDir);
			return "index";
		}
		return "redirect:login.jsp";
	}
}
