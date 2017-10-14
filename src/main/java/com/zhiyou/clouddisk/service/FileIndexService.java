package com.zhiyou.clouddisk.service;

import java.util.List;

import com.zhiyou.clouddisk.model.FileIndex;

import javafx.print.PageLayout;
import test.model.PFileIndex;

public interface FileIndexService {
	public void addFileIndex(FileIndex fileIndex);
	public List<FileIndex> getRootFilesByUserId(Long userId);
	public FileIndex getRootDirByUserId(Long userId);
	public FileIndex getFileIndexById(Long valueOf);
	public List<FileIndex> getChildrenFileById(Long valueOf);
	public FileIndex getFileIndexByPath(String path, Long userId);
	public FileIndex getFileIndexBypId(Long userId, String pFileIndexId);
	public void updateFileName(FileIndex fileIndex);
	public void deleteFile(FileIndex fileIndex);
	public List getOptionTranPath(Long fileIndexId);
	public void transferFileIndex(FileIndex fileIndex, String newPathId);
	public List getPageLayout();
	public List<FileIndex> searchFileByPage(String keyWord, int pageNum, int pageNo);
	public List getStaticNums(Long userId);
}
