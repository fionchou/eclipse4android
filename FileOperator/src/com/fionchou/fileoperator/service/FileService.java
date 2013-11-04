package com.fionchou.fileoperator.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;


public class FileService {

	private Context context;

	public FileService(Context context) {
		this.context = context;
	}

	/**
	 * 保存文件
	 * @param fileNameText 文件名称
	 * @param fileContentText 文件内容
	 * @throws IOException 
	 */
	public void saveFile(String fileNameText, String fileContentText) throws IOException {
		FileOutputStream outputStream = context.openFileOutput(fileNameText, Context.MODE_PRIVATE);
		outputStream.write(fileContentText.getBytes());
		outputStream.close();
	}
	
	/**
	 * 读取文件内容
	 * @param fileNameText 文件名称
	 * @return fileContentText 文件内容
	 * @throws IOException
	 */
	public String readFile(String fileNameText) throws IOException {
		FileInputStream inputStream = context.openFileInput(fileNameText);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inputStream.read(buffer)) != -1){
			outputStream.write(buffer,0,len);
		}
		byte[] data = outputStream.toByteArray();
		return new String(data);
	}

}
