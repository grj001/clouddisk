package com.zhiyou.clouddisk.service;

import java.util.List;

import com.zhiyou.clouddisk.model.AppUser;

public interface AppUserService {
	public List<AppUser> getAppUsers();
	public void saveAppUser(AppUser appUser);
	public AppUser login(AppUser appUser);
}
