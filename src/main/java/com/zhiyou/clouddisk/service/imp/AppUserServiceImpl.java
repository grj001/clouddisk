package com.zhiyou.clouddisk.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.clouddisk.dao.AppUserDao;
import com.zhiyou.clouddisk.model.AppUser;
import com.zhiyou.clouddisk.model.FileIndex;
import com.zhiyou.clouddisk.service.AppUserService;
import com.zhiyou.clouddisk.service.FileIndexService;

@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserDao appUserDao;
	
	@Autowired
	private FileIndexService fileIndexService;
	
	public List<AppUser> getAppUsers() {
		return appUserDao.getAppUsers();
	}

	public void saveAppUser(AppUser appUser) {
		if(appUser!=null){
			if(appUser.getUserId() != null){
				//修改
				appUserDao.update(appUser);
			}else{
				//新增
				appUserDao.add(appUser);
				//新增用户添加其根路径
				FileIndex fileIndex = new FileIndex();
				fileIndex.setCreateTime(new Date());
				fileIndex.setName("根路径");
				fileIndex.setPath("/");
				fileIndex.setIsFile("1");
				fileIndex.setUserId(appUser.getUserId());
				fileIndexService.addFileIndex(fileIndex);
			}
		}
	}

	public AppUser login(AppUser appUser) {
		return appUserDao.getAppUserByAccountNo(appUser.getAccountNo());
	}
	
}
