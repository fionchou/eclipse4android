package com.fionchou.otherfileoperator.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.util.Log;

public class OtherFileService {

	private final static String tag ="OtherFileService";
	/**
	 * 读取文件内容
	 * @param filename 文件名称
	 * @throws IOException
	 */
	public void access(String filename) throws IOException {
		String path = "/data/data/com.fionchou.fileoperator/files/"+filename;
	    FileInputStream inputStream = new FileInputStream(path);
	    
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
		
	    int len = 0;
		while((len = inputStream.read(buffer)) != -1){
			outputStream.write(buffer,0,len);
		}
		byte[] data = outputStream.toByteArray();
		String content = new String(data);
		outputStream.close();
		inputStream.close();
		
		Log.i(tag, content);
	}
	
	/**
	 * 写入文件
	 * @param filename 文件名称
	 * @throws IOException
	 */
	public void write(String filename) throws IOException {
		String path = "/data/data/com.fionchou.fileoperator/files/"+filename;
		File file =new File(path);
	    FileOutputStream outputStream = new FileOutputStream(file,true);//追加写入文件
	    outputStream.write("test".getBytes());
	    outputStream.close();
	    
	}
}
