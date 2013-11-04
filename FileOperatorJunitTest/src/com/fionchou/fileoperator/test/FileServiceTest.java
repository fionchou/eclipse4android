package com.fionchou.fileoperator.test;

import java.io.IOException;

import com.fionchou.fileoperator.service.FileService;

import android.test.AndroidTestCase;

public class FileServiceTest extends AndroidTestCase {

	public void testSave() throws IOException{
		FileService fileService = new FileService(this.getContext());
		fileService.saveFile("private.txt", "www.fionchou.com");
	}
	
	public void testSaveAppen() throws IOException{
		FileService fileService = new FileService(this.getContext());
		fileService.saveFileAppend("append.txt", "append.www.fionchou.com");
	}
	
	public void testSaveReadable() throws IOException{
		FileService fileService = new FileService(this.getContext());
		fileService.saveFileReadable("readable.txt", "readable.www.fionchou.com");
	}
	
	public void testSaveWriteable() throws IOException{
		FileService fileService = new FileService(this.getContext());
		fileService.saveFileWriteable("writeable.txt", "writeable.www.fionchou.com");
	}
	
	public void testSaveFileRW() throws IOException{
		FileService fileService = new FileService(this.getContext());
		fileService.saveFileRW("rw.txt", "rw.www.fionchou.com");
	}
	
}
