package com.zhiyou.clouddisk.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.clouddisk.model.FileIndex;

public interface FileIndexDao {
	public void addFileIndex(FileIndex fileIndex);
	public List<FileIndex> getRootFilesByUserId(Long userId);
	public FileIndex getRootDirByUserId(Long userId);
	public FileIndex getFileIndexById(Long fiId);
	public List<FileIndex> getChildrenFileById(Long fiId);
	public FileIndex getFileIndexByPath(@Param("path")String path, @Param("userId")Long userId);
	public List getFileIndexBypId(Map condition);
	public void updateFile(FileIndex fileIndex);
	public List<FileIndex> getSubFiles(FileIndex fileIndex);
	public List getOptionTranPath(Long fileIndexId);
	public List<FileIndex> searchFile(String keyWord);
	public List getStaticNums(Long userId);
}
