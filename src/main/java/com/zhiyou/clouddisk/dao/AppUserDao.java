package com.zhiyou.clouddisk.dao;

import java.util.List;

import com.zhiyou.clouddisk.model.AppUser;

public interface AppUserDao {
	public List<AppUser> getAppUsers();

	public void update(AppUser appUser);

	public void add(AppUser appUser);

	public AppUser getAppUserByAccountNo(String accountNo);
}
