package com.example.news;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

@SuppressLint("HandlerLeak")
public class DrawableLoad {
	static Map<String,SoftReference<Drawable>> map = new HashMap<String,SoftReference<Drawable>>();
	
	public static Drawable getDrawabl(final String path,final DrawbalesLoad load){
		if(map.containsKey(path)){
			SoftReference<Drawable> soft = map.get(path);
			if(soft.get()!=null){
				return soft.get();
			}
		}
		
		final Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				load.ImageLoad((Drawable) msg.obj);
			}
		};
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Drawable draw;
				try {
					draw = getImageLoad(path);
					map.put(path, new SoftReference<Drawable>(draw));
					Message msg = handler.obtainMessage(0, draw);
					handler.sendMessage(msg);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		return null;
	} 
	
	public static Drawable getImageLoad(String path) throws MalformedURLException, IOException{
		//根据图片的URL，下载图片，并生成一个Drawable对象
		Drawable draw = null;
		draw = Drawable.createFromStream(new URL(path).openStream(), "src");
		return draw;
	}
	
	public interface DrawbalesLoad{
		public void ImageLoad(Drawable draw);
	}
}






























