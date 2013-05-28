package com.lq.tabfragmenttest;


import com.lq.tabfragmenttest.fragment.DefaultFragment;
import com.lq.tabfragmenttest.fragment.Tab1Fragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	public Tab1Fragment tab1Fragment;
	public DefaultFragment defaultFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		View top_layout = findViewById(R.id.top_layout);
		top_layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, TabFragment.class);
//				startActivity(intent);
			}
		});
	}

	private void init() {
		tab1Fragment = (Tab1Fragment) getFragmentManager().findFragmentById(R.id.main_fragment);
//		defaultFragment = (DefaultFragment) getFragmentManager().findFragmentById(R.id.main_fragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
