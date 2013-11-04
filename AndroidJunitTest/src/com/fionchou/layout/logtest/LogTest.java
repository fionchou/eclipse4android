package com.fionchou.layout.logtest;

import android.test.AndroidTestCase;
import android.util.Log;

public class LogTest extends AndroidTestCase {

	public static final String LogTag="LogTest";
	
	public void testOutLog() {
		Log.i(LogTag, "www.fionchou.com");
	}
	
	public void testOutLogCn() {
		Log.i(LogTag, "·ë¶÷³ó");
	}
	
	public void testOutLogSystemOut() {
		System.out.println("·ë¶÷³ó");
	}
	
	public void testOutLogSystemErr() {
		System.err.println("·ë¶÷³ó");
	}
	
	
}
