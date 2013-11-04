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
	 * �����ļ�
	 * @param fileNameText �ļ�����
	 * @param fileContentText �ļ�����
	 * @throws IOException 
	 */
	public void saveFile(String fileNameText, String fileContentText) throws IOException {
		FileOutputStream outputStream = context.openFileOutput(fileNameText, Context.MODE_PRIVATE);
		write(fileContentText, outputStream);
	}
	
	/**
	 * �����ļ�
	 * @param fileNameText �ļ�����
	 * @param fileContentText �ļ�����
	 * @throws IOException 
	 */
	public void saveFileAppend(String fileNameText, String fileContentText) throws IOException {
		FileOutputStream outputStream = context.openFileOutput(fileNameText, Context.MODE_APPEND);
		write(fileContentText, outputStream);
	}
	
	/**
	 * �����ļ�
	 * @param fileNameText �ļ�����
	 * @param fileContentText �ļ�����
	 * @throws IOException 
	 */
	public void saveFileReadable(String fileNameText, String fileContentText) throws IOException {
		FileOutputStream outputStream = context.openFileOutput(fileNameText, Context.MODE_WORLD_READABLE);
		write(fileContentText, outputStream);
	}
	
	/**
	 * �����ļ�
	 * @param fileNameText �ļ�����
	 * @param fileContentText �ļ�����
	 * @throws IOException 
	 */
	public void saveFileWriteable(String fileNameText, String fileContentText) throws IOException {
		FileOutputStream outputStream = context.openFileOutput(fileNameText, Context.MODE_WORLD_WRITEABLE);
		write(fileContentText, outputStream);
	}
	
	/**
	 * �����ļ�
	 * @param fileNameText �ļ�����
	 * @param fileContentText �ļ�����
	 * @throws IOException 
	 */
	public void saveFileRW(String fileNameText, String fileContentText) throws IOException {
		FileOutputStream outputStream = context.openFileOutput(fileNameText, Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
		write(fileContentText, outputStream);
	}

	private void write(String fileContentText, FileOutputStream outputStream)
			throws IOException {
		outputStream.write(fileContentText.getBytes());
		outputStream.close();
	}
	
	/**
	 * ��ȡ�ļ�����
	 * @param fileNameText �ļ�����
	 * @return fileContentText �ļ�����
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
