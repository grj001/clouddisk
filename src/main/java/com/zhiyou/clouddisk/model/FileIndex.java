package com.zhiyou.clouddisk.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FileIndex {
	private Long fileIndexId;
	private Long userId;
	private Long pFileIndexId;
	private String name;
	private String path;
	private Long parentId;
	private String isFile;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String deleteFlag;
	
	
	public Long getFileIndexId() {
		return fileIndexId;
	}
	public void setFileIndexId(Long fileIndexId) {
		this.fileIndexId = fileIndexId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getpFileIndexId() {
		return pFileIndexId;
	}
	public void setpFileIndexId(Long pFileIndexId) {
		this.pFileIndexId = pFileIndexId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getIsFile() {
		return isFile;
	}
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "FileIndex [fileIndexId=" + fileIndexId + ", userId=" + userId + ", pFileIndexId=" + pFileIndexId
				+ ", name=" + name + ", path=" + path + ", parentId=" + parentId + ", isFile=" + isFile
				+ ", createTime=" + createTime + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
}
