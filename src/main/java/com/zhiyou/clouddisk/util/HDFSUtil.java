package com.zhiyou.clouddisk.util;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSUtil {
	public static final Configuration CONFIGURATION = new Configuration();
	//获取FileSystem对象
	public static FileSystem getFileSystem() throws Exception{
		return FileSystem.get(CONFIGURATION);
	}
	public static String uploadFileToHdfs(InputStream iStream,String pathStr) throws Exception{
		FileSystem hdfs = getFileSystem();
		FSDataOutputStream oStream = hdfs.create(new Path(pathStr));
		byte[] buffer = new byte[1024];
		int length = iStream.read(buffer, 0, 1024);
		//获取md5加密对象
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		while(length>-1){
			if(length<1024){
				byte[] last = Arrays.copyOf(buffer, length);
				md.update(last);
				oStream.write(last);
			}else{
				md.update(buffer);
				oStream.write(buffer);
			}
			length = iStream.read(buffer,0,length);
//			System.out.println(length);
		}
		oStream.hsync();
		hdfs.close();
		oStream.close();
		BigInteger bigInteger = new BigInteger(1,md.digest());
		System.out.println("文件的md5："+bigInteger.toString(16));
		return bigInteger.toString(16);
	}
}
