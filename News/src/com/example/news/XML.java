package com.example.news;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class XML {
	static Get get = null;
	
	public static List<Get> getXml(InputStream path){
		List<Get> list = new ArrayList<Get>();
		
		try {
			XmlPullParser xml = Xml.newPullParser();
			xml.setInput(path, "utf-8");
			int type = xml.getEventType();
			while(type!=XmlPullParser.END_DOCUMENT){
				switch(type){
				case XmlPullParser.START_TAG:
					if(xml.getName().equals("news")){
						get = new Get();
					}else if(xml.getName().equals("title")){
						get.setTitle(xml.nextText());
					}else if(xml.getName().equals("detail")){
						get.setDetail(xml.nextText());
					}else if(xml.getName().equals("comment")){
						get.setComment(xml.nextText());
					}else if(xml.getName().equals("time")){
						get.setTime(xml.nextText());
					}else if(xml.getName().equals("image")){
						get.setImage(xml.nextText());
					}else if(xml.getName().equals("imagedata")){
						get.setImagedata(xml.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if(xml.getName().equals("news")){
						list.add(get);
					}
					break;
				}
				
				type = xml.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	} 
}









