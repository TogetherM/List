
package com.example.news;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
	
	public static String getTextFromUtil(InputStream is){
		try {
			int count = 0;
			byte[] bu = new byte[1024];
			ByteArrayOutputStream by = new ByteArrayOutputStream();
			while((count = is.read(bu))!=-1){
				by.write(bu, 0, count);
			}
			
			return new String(by.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
