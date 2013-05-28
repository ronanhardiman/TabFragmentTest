package com.lq.tabfragmenttest.fragment;


import com.lq.tabfragmenttest.R;
import com.lq.tabfragmenttest.customactionbar.ActionBar;
import com.lq.tabfragmenttest.customactionbar.ActionBar.Action;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.MotionEvent;
import android.view.View;

public class TabFragment extends FragmentActivity {
	private FragmentTabHost mTabHost;
	private float lastY;
	private float lastX;
	private boolean mIsTitleHide = false;
	private boolean mIsAnim = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_tabs2);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
				DefaultFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
				DefaultFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
				DefaultFragment.class, null);
		initCustomActionBar();
		initActionBar();
	}
	
	private void initActionBar() {
		
	}

	private void initCustomActionBar() {
//		final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        //actionBar.setHomeAction(new IntentAction(this, createIntent(this), R.drawable.ic_title_home_demo));
//        actionBar.setTitle("Home");
        
        
        
//        final Action shareAction = new IntentAction(this, createShareIntent(), R.drawable.ic_title_share_default);
//        actionBar.addAction(shareAction);
//        final Action otherAction = new IntentAction(this, new Intent(this, OtherActivity.class), R.drawable.ic_title_export_default);
//        actionBar.addAction(otherAction);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		super.dispatchTouchEvent(ev);
		final int action = ev.getAction();

		float x = ev.getX();
		float y = ev.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			lastY = y;
			lastX = x;
			return false;
		case MotionEvent.ACTION_MOVE:
			float dY = Math.abs(y - lastY);
			float dX = Math.abs(x - lastX);
			boolean down = y > lastY ? true : false;
			lastY = y;
			lastX = x;
			if (dX < 8 && dY > 8 && !mIsTitleHide && !down) {// 首页上滑操作
																// bottom_bar 隐藏
//				Animation anim = new TranslateAnimation(0, 0, 0, 0,
//						Animation.RELATIVE_TO_SELF, 0.0f,
//						Animation.RELATIVE_TO_SELF, -1.0f);
//				anim.setDuration(200);
//				anim.setFillAfter(true);
//
//				mTabHost.getTabWidget().startAnimation(anim);
				mTabHost.getTabWidget().setVisibility(View.GONE);
			} else if (dX < 8 && dY > 8 && mIsTitleHide && down) {// 下滑操作
																	// bottom_bar
																	// 显示
//				Animation anim = new TranslateAnimation(0, 0, 0, 0,
//						Animation.RELATIVE_TO_SELF, -1.0f,
//						Animation.RELATIVE_TO_SELF, 0.0f);
//				anim.setDuration(200);
//				mTabHost.getTabWidget().startAnimation(anim);
				mTabHost.getTabWidget().setVisibility(View.VISIBLE);
			} else {
				return false;
			}
			mIsTitleHide = !mIsTitleHide;
			mIsAnim = true;
			break;
		case MotionEvent.ACTION_UP:
			break;

		default:
			return false;
		}
		return false;
	}
}
