package com.zhiyou.clouddisk.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.clouddisk.model.AppUser;
import com.zhiyou.clouddisk.model.FileIndex;
import com.zhiyou.clouddisk.service.FileIndexService;
import com.zhiyou.clouddisk.service.PFileIndexService;
import com.zhiyou.clouddisk.util.HDFSUtil;

import sun.launcher.resources.launcher;
import test.model.PFileIndex;

@Controller
public class FileIndexController {
	@Autowired
	private FileIndexService fileIndexService;
	@Autowired
	private PFileIndexService pFileIndexService;
	
	@RequestMapping(value="/saveDirectory",method=RequestMethod.POST)
	public String saveDirectory(String directName,String parentId,String parentPath,@SessionAttribute("user") AppUser user){
		//保存新增的目录信息
		FileIndex fileIndex = new FileIndex();
		fileIndex.setCreateTime(new Date());
		fileIndex.setIsFile("1");
		fileIndex.setName(directName);
		fileIndex.setParentId(Long.valueOf(parentId));
		fileIndex.setPath(parentPath+(parentPath.endsWith("/")?"":"/")+directName);
		fileIndex.setUserId(user.getUserId());
		//保存到数据库
		fileIndexService.addFileIndex(fileIndex);
		return "redirect:openDirectory?dirId="+parentId;
	}
	@RequestMapping(value="/openDirectory")
	public String openDirectory(String dirId,@SessionAttribute("user")AppUser user,Model model){
		FileIndex rootDir = null;
		if(dirId==null||dirId.equals("")){
			rootDir = fileIndexService.getRootDirByUserId(user.getUserId());
			dirId = rootDir.getFileIndexId().toString();
		}else{
			//查询dirId结果，并以rootDir的名称传到index.jsp中
			//查询dirId目录下的所有子文件和子文件夹，并以rootFiles的名称传递到index.jsp
			rootDir = fileIndexService.getFileIndexById(Long.valueOf(dirId));
		}
		
		List<FileIndex> rootFiles = fileIndexService.getChildrenFileById(Long.valueOf(dirId));
		model.addAttribute("rootDir",rootDir);
		model.addAttribute("rootFiles",rootFiles);
		fileIndexService.getPageLayout();//ceshiv
		return "index";
	}
	@RequestMapping(value="/uploadFile")
	public String uploadFile(@RequestParam(value="file") MultipartFile file,String parentId,String parentPath,@SessionAttribute("user")AppUser user) throws Exception{
		//接受前台传输过来的文件，并且存放到hdfs上
		//获取源文件名称
		String fileName = file.getOriginalFilename();
		InputStream fis = file.getInputStream();
		Long size = file.getSize();
		String md5 = HDFSUtil.uploadFileToHdfs(fis, "/couddisk/"+fileName);
		PFileIndex pFileIndex = new PFileIndex();
		pFileIndex.setFileMd5(md5);
		pFileIndex.setCreateTime(new Date());
		pFileIndex.setFileSize(size);
		pFileIndex.setpName(fileName);
		pFileIndex.setpPath("/couddisk/"+fileName);
		
		FileIndex fileIndex = new FileIndex();
		fileIndex.setCreateTime(new Date());
		fileIndex.setIsFile("0");
		fileIndex.setName(pFileIndex.getpName());
		fileIndex.setParentId(Long.valueOf(parentId));
		fileIndex.setPath(parentPath+"/"+fileName);
		fileIndex.setUserId(user.getUserId());
		
		pFileIndexService.addPFileIndex(pFileIndex,fileIndex);
		
		return "redirect:openDirectory?dirId="+parentId;
	}
	@ResponseBody
	@RequestMapping(value="/checkMD5",method=RequestMethod.POST)
	public String checkMD5(String md5code){
		//校验云盘中是否已存在MD5等于md5code的文件
		return pFileIndexService.checkMD5(md5code);
	}
	
	@RequestMapping(value="/uploadSecendly",method=RequestMethod.POST)
	public String uploadSecendly(@RequestParam String fileMD5,String fileName,String parentId,String parentPath,@SessionAttribute("user") AppUser appUser){
		//保存一条记录到fileindex表中
		FileIndex fileIndex = new FileIndex();
		fileIndex.setCreateTime(new Date());
		fileIndex.setIsFile("0");
		fileIndex.setName(fileName);
		fileIndex.setParentId(Long.valueOf(parentId));
		fileIndex.setPath(parentPath+"/"+fileName);
		//根据md5获取物理文件记录id
		PFileIndex pFileIndex = pFileIndexService.getPFIByMD5(fileMD5);
		fileIndex.setpFileIndexId(pFileIndex.getpFileIndexId());
		fileIndex.setUserId(appUser.getUserId());
		//保存进数据库
		fileIndexService.addFileIndex(fileIndex);
		//刷新页面上的目录
		return "redirect:openDirectory?dirId="+parentId;
	}
	@RequestMapping("openDirByPath")
	public String openDirByPath(String path,@SessionAttribute("user") AppUser appUser){
		FileIndex fileIndex = fileIndexService.getFileIndexByPath(path,appUser.getUserId());
		return "redirect:openDirectory?dirId="+fileIndex.getFileIndexId();
	}
	@RequestMapping("downloadFile")
	public void downloadFile(String pFileIndexId,HttpServletResponse response,@SessionAttribute("user") AppUser user) throws Exception{
		//校验用户是否拥有该物理文件
		//该文件对应用户的逻辑文件名
		FileIndex fileIndex = fileIndexService.getFileIndexBypId(user.getUserId(),pFileIndexId);
		if(fileIndex==null){
			response.sendRedirect("报错的路径");
		}
		//该文件的物理路径
		PFileIndex pFileIndex = pFileIndexService.getPFIById(Long.valueOf(pFileIndexId));
		
		//从物理路径处读取文件
		String pPath = pFileIndex.getpPath();
		Path path = new Path(pPath);
		FileSystem hdfs = HDFSUtil.getFileSystem();
		FSDataInputStream fsDataInputStream =  hdfs.open(path);
		
		//设置编码格式
		response.setCharacterEncoding("utf-8");
		//设置返回内容类型
		response.setContentType("multipart/form-data");
		//设置相应返回头
		response.setHeader("Content-Disposition", "attachment;fileName="+fileIndex.getName());
		//获取响应输出流
		OutputStream oStream = response.getOutputStream();
		
		//从fsDataInputStream中读取，然后写入到oStream 中
		byte[] buffer = new byte[1024];
		int length = fsDataInputStream.read(buffer, 0, 1024);
		while(length>-1){
			if(length<1024){
				byte[] last = Arrays.copyOf(buffer, length);
				oStream.write(last);
			}else{
				oStream.write(buffer);
			}
			length = fsDataInputStream.read(buffer, 0, length);
		}
		oStream.flush();
		fsDataInputStream.close();
	}
	//spring mvc的文件下载方式。快速，但是不适用于大文件
	@RequestMapping("/mvcFileDownload")
	public ResponseEntity<byte[]> mvcFileDownload(String pFileIndexId,@SessionAttribute("user") AppUser user) throws Exception{
		FileIndex fileIndex = fileIndexService.getFileIndexBypId(user.getUserId(),pFileIndexId);
		//该文件的物理路径
		PFileIndex pFileIndex = pFileIndexService.getPFIById(Long.valueOf(pFileIndexId));
		//从物理路径处读取文件
		String pPath = pFileIndex.getpPath();
		Path path = new Path(pPath);
		FileSystem hdfs = HDFSUtil.getFileSystem();
		FSDataInputStream fsDataInputStream =  hdfs.open(path);
		
		//构建封装文件下载返回对象
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileIndex.getName());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		byte[] down = new byte[fsDataInputStream.available()];
		fsDataInputStream.readFully(down);
		return new ResponseEntity(down,headers,HttpStatus.CREATED);
	}
	@RequestMapping("renameForm")
	public String renameForm(String directName,String isRoot,String fileIndexId,@SessionAttribute("user")AppUser user){
		//修改fileindex的name和path
		//修改子目录下的path
		FileIndex fileIndex = fileIndexService.getFileIndexById(Long.valueOf(fileIndexId));
		fileIndex.setName(directName);
		fileIndexService.updateFileName(fileIndex);
		//判断是修改本目录名称还是修改子目录名称，本目录名称修改完依然跳转到本目录页面，修改子目录的名称的话还是跳转到本目录
		if(isRoot!=null && isRoot.equals("yes")){
			return "redirect:openDirectory?dirId=" + fileIndexId;
		}else{
			return "redirect:openDirectory?dirId=" + fileIndex.getParentId();
		}
	}
	@RequestMapping("/deleteFile/{fileIndexId}")
	public String deleteFile(@PathVariable("fileIndexId") String fileIndexId,@SessionAttribute("user") AppUser user){
		FileIndex fileIndex = fileIndexService.getFileIndexById(Long.valueOf(fileIndexId));
		fileIndexService.deleteFile(fileIndex);
		return "redirect:../openDirectory?dirId=" + fileIndex.getParentId();
	}
	@RequestMapping("/getOptionalPath")
	@ResponseBody
	public List getOptionalPath(String fileIndexId){
		//查询出当前fileIndexId可转移的目录集合，当前用户下该目录以及该目录的子目录不可选
		List result =  fileIndexService.getOptionTranPath(Long.valueOf(fileIndexId));
		return result;
	}
	@RequestMapping(value="/transferForm",method=RequestMethod.POST)
	public String transferForm(String nowPathId,String newPathId){
		//文件或者文件夹转移过程
		FileIndex fileIndex = fileIndexService.getFileIndexById(Long.valueOf(nowPathId));
		fileIndexService.transferFileIndex(fileIndex,newPathId);
		return "redirect:openDirectory?dirId=" + fileIndex.getParentId();
	}
	@RequestMapping("/searchFiles")
	public String searchFiles(String keyWord,@RequestParam(value="pageNum",defaultValue="1")int pageNum,Model model){
		int pageSize = 3;
		List<FileIndex> result = fileIndexService.searchFileByPage(keyWord,pageSize,pageNum);
		model.addAttribute("result", result);
		model.addAttribute("keyWord",keyWord);
		return "searchResult";
	}
	@RequestMapping("/stasticFiles")
	public String stasticFiles(@SessionAttribute("user") AppUser user,Model model){
		List staticResult = fileIndexService.getStaticNums(user.getUserId());
		model.addAttribute("staticResult", staticResult);
		return "stasticfiles";
	}
}
