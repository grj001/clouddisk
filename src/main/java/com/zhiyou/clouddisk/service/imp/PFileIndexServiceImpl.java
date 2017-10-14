package com.zhiyou.clouddisk.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.clouddisk.dao.FileIndexDao;
import com.zhiyou.clouddisk.dao.PFileIndexMapper;
import com.zhiyou.clouddisk.model.FileIndex;
import com.zhiyou.clouddisk.service.PFileIndexService;

import test.model.PFileIndex;
import test.model.PFileIndexExample;
@Service
public class PFileIndexServiceImpl implements PFileIndexService {
	@Autowired
	private PFileIndexMapper pFileIndexMapper;
	@Autowired
	private FileIndexDao fileIndexDao;
	
	public int addPFileIndex(PFileIndex pFileIndex,FileIndex fileIndex) {
		int result = pFileIndexMapper.insert(pFileIndex);
		
		fileIndex.setpFileIndexId(pFileIndex.getpFileIndexId());
		fileIndexDao.addFileIndex(fileIndex);
		
		return result;
	}
	//校验给定MD5的文件在hdfs上是否已存在
	public String checkMD5(String md5code) {
		PFileIndexExample example = new PFileIndexExample();
		example.createCriteria().andFileMd5EqualTo(md5code);
		List<PFileIndex> pfis = pFileIndexMapper.selectByExample(example);
		if(pfis!=null && pfis.size()>0){
			return "yes";
		}else{
			return "no";
		}
	}
	//根据MD5值来获取文件的物理路径记录
	public PFileIndex getPFIByMD5(String fileMD5) {
		PFileIndexExample example = new PFileIndexExample();
		example.createCriteria().andFileMd5EqualTo(fileMD5);
		List<PFileIndex> pfis = pFileIndexMapper.selectByExample(example);
		if(pfis!=null && pfis.size()>0){
			return pfis.get(0);
		}else{
			return null;
		}
	}
	public PFileIndex getPFIById(Long valueOf) {
		return pFileIndexMapper.selectByPrimaryKey(valueOf);
	}
	
}
