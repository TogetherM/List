package com.example.news;

import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity implements OnItemClickListener{
	List<Get> list;
	
	ListView listview;
	
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0x123){
				listview.setAdapter(new MyList());
				listview.setOnItemClickListener(MainActivity.this);
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listview = getListView();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				list = ReturnURL.getString(MyURL.path);
				handler.sendEmptyMessage(0x123);
			}
		}).start();
	}
	
	class MyList extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@SuppressLint("ViewHolder")
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			DrawableLoad load = new DrawableLoad();
			View view = View.inflate(MainActivity.this, R.layout.list, null);
			ImageView image = (ImageView) view.findViewById(R.id.image);
			TextView title = (TextView) view.findViewById(R.id.title);
			TextView time = (TextView) view.findViewById(R.id.time);
			ImageView zan = (ImageView) view.findViewById(R.id.zan);
			TextView zan_text = (TextView) view.findViewById(R.id.text_zan);
			
			title.setText(list.get(position).getTitle());
			time.setText(list.get(position).getTime());
			zan_text.setText(list.get(position).getComment());
			
			//获取缓存资源
			image.setImageDrawable(DrawableLoad.getDrawabl(list.get(position).getImage(), new MyDraw(image)));
			zan.setImageDrawable(DrawableLoad.getDrawabl(list.get(position).getImagedata(), new MyDraw(zan)));
			
			return view;
		}
	}
	
	class MyDraw implements DrawableLoad.DrawbalesLoad{
		ImageView image;
		public MyDraw(ImageView image) {
			this.image = image;
		}
		@Override
		public void ImageLoad(Drawable draw) {
			// TODO Auto-generated method stub
			image.setImageDrawable(draw);
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent i = new Intent(MainActivity.this, Other.class);
		i.putExtra("data", list.get(position).getDetail());
		startActivity(i);
	}
}
















