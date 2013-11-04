package com.fionchou.otherfileoperator.test;

import java.io.IOException;

import com.fionchou.otherfileoperator.service.OtherFileService;

import android.test.AndroidTestCase;

public class OtherFileServiceTest extends AndroidTestCase {

	public void testAccessPrivate() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.access("private.txt");
	}
	
	public void testAccessAppen() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.access("append.txt");
	}
	
	public void testAccessReadable() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.access("readable.txt");
	}
	
	public void testAccessWriteable() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.access("writeable.txt");
	}
	
	//���Ӧ��д���Ӧ�ô������ļ�
	public void testWriteWriteable() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.write("writeable.txt");
	}
	
	public void testAccessRW() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.access("rw.txt");
	}
	
	//���Ӧ��д���Ӧ�ô������ļ�
	public void testWriteRW() throws IOException{
		OtherFileService otherFileService = new OtherFileService();
		otherFileService.write("rw.txt");
	}
	
}
