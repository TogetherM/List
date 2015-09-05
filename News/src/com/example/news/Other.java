package com.example.news;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Other extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		
		String str = getIntent().getStringExtra("data");
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(str);
	}
}
