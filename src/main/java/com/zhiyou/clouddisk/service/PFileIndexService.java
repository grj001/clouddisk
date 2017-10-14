package com.zhiyou.clouddisk.service;

import com.zhiyou.clouddisk.model.FileIndex;

import test.model.PFileIndex;

public interface PFileIndexService {
	public int addPFileIndex(PFileIndex pFileIndex,FileIndex fileIndex);

	public String checkMD5(String md5code);

	public PFileIndex getPFIByMD5(String fileMD5);

	public PFileIndex getPFIById(Long valueOf);
}
