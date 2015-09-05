package com.example.news;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ReturnURL {
	public static List<Get> getString(String path){
		List<Get> list = null;
		
		try {
			URL url = new URL(path);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setConnectTimeout(5000);
			//读取时间
			http.setRequestMethod("GET");
			//请求时间
			http.setConnectTimeout(5000);
			//与服务器建立联系
			http.connect();
			if(http.getResponseCode()==200){
				InputStream is = http.getInputStream();
				list = XML.getXml(is);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
