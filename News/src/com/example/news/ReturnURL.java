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
			//��ȡʱ��
			http.setRequestMethod("GET");
			//����ʱ��
			http.setConnectTimeout(5000);
			//�������������ϵ
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
