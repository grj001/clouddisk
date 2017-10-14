package com.zhiyou.clouddisk.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhiyou.clouddisk.dao.FileIndexDao;
import com.zhiyou.clouddisk.model.FileIndex;
import com.zhiyou.clouddisk.service.FileIndexService;

import test.model.PFileIndex;
@Service
public class FileIndexServiceImpl implements FileIndexService {
	@Autowired
	private FileIndexDao fileIndexDao;
	
	public void addFileIndex(FileIndex fileIndex) {
		fileIndexDao.addFileIndex(fileIndex);
	}

	public List<FileIndex> getRootFilesByUserId(Long userId) {
		if(userId==null){
			return null;
		}else{
			return fileIndexDao.getRootFilesByUserId(userId);
		}
	}

	public FileIndex getRootDirByUserId(Long userId) {
		
		return fileIndexDao.getRootDirByUserId(userId);
	}

	public FileIndex getFileIndexById(Long fiId) {
		
		return fileIndexDao.getFileIndexById(fiId);
	}

	public List<FileIndex> getChildrenFileById(Long fiId) {
		
		return fileIndexDao.getChildrenFileById(fiId);
	}

	public FileIndex getFileIndexByPath(String path, Long userId) {
		return fileIndexDao.getFileIndexByPath(path,userId);
	}

	public FileIndex getFileIndexBypId(Long userId, String pFileIndexId) {
		Map condition = new HashMap();
		condition.put("userId", userId);
		condition.put("pFileIndexId", pFileIndexId);
		List result = fileIndexDao.getFileIndexBypId(condition);
		if(result!=null && result.size()>0){
			return (FileIndex)result.get(0);
		}else{
			return null;
		}
		
	}

	public void updateFileName(FileIndex fileIndex) {
		//修改fileindex的name和path
		String path = fileIndex.getPath();
		fileIndex.setPath(path.substring(0,path.lastIndexOf("/"))+"/"+fileIndex.getName());
		fileIndexDao.updateFile(fileIndex);
		
		FileIndex newPath = new FileIndex();
		newPath.setPath(path);
		newPath.setUserId(fileIndex.getUserId());
		//修改子目录下的path
		List<FileIndex> subFiles = fileIndexDao.getSubFiles(newPath);
		for(FileIndex f:subFiles){
			String childPath = f.getPath();
			f.setPath(fileIndex.getPath()+childPath.substring(path.length(),childPath.length()));
			fileIndexDao.updateFile(f);
		}
	}
	//deleteflag置为1表示将其存放在回收站，为2表示彻底删除
	//为空表示正常
	public void deleteFile(FileIndex fileIndex) {
		fileIndex.setDeleteFlag("1");
		fileIndexDao.updateFile(fileIndex);
		//文件夹则删除其子文件夹和子文件
		if(fileIndex.getIsFile().equals("1")){
			List<FileIndex> subFiles = fileIndexDao.getSubFiles(fileIndex);
			for(FileIndex f:subFiles){
				f.setDeleteFlag("1");
				fileIndexDao.updateFile(f);
			}
		}
	}

	public List getOptionTranPath(Long fileIndexId) {
		return fileIndexDao.getOptionTranPath(fileIndexId);
	}

	public void transferFileIndex(FileIndex fileIndex, String newPathId) {
		//转移文件到一个新的目录下面
		//该fileIndex的path字段和parentId字段需要更新
		//如果该fileIndex是文件的话就结束，如果该fileIndex是目录的话还要修改其子目录子文件的path
		FileIndex parentFileIndex = fileIndexDao.getFileIndexById(Long.valueOf(newPathId));
		fileIndex.setParentId(parentFileIndex.getFileIndexId());
		String oldPath = fileIndex.getPath();
		String newPath = parentFileIndex.getPath() 
				+ (parentFileIndex.getPath().equals("/")?"":"/")+fileIndex.getName();
		fileIndex.setPath(newPath);
		fileIndexDao.updateFile(fileIndex);
		if(fileIndex.getIsFile().equals("1")){
			//更新级联的子文件子目录的path
			List<FileIndex> children = fileIndexDao.getChildrenFileById(fileIndex.getFileIndexId());
			if(children!=null && children.size()>0){
				for(FileIndex child:children){
					child.setPath(child.getPath().replaceFirst(oldPath, newPath));
					fileIndexDao.updateFile(child);
				}
			}
		}
	}

	public List getPageLayout() {
		Page<FileIndex> page = PageHelper.startPage(2, 3);
		List list = fileIndexDao.getRootFilesByUserId(139l);
		return null;
	}
	//分页查询结果
	public List<FileIndex> searchFileByPage(String keyWord, int pageSize, int pageNum) {
		if(keyWord==null||keyWord.trim().equals("")){
			keyWord = "";
		}
		Page<FileIndex> page = PageHelper.startPage(pageNum, pageSize);
		fileIndexDao.searchFile(keyWord);
		return page;
	}

	public List getStaticNums(Long userId) {
		return fileIndexDao.getStaticNums(userId);
	}
}
