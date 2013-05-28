package com.lq.tabfragmenttest.customview;
import com.lq.tabfragmenttest.R;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 首页HomeTopBar
 * 
 * @author liq
 * 
 */
public class NewHomeTopBar extends LinearLayout {

	Context mContext;
	private Button recommend_button;
	private Button hotspot_button;
	private Button tieba_button;

	public NewHomeTopBar(Context context) {
		this(context, null);
	}

	public NewHomeTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		LayoutInflater.from(context).inflate(R.layout.new_home_bar, this, true);
		ininLayout();
//		ininBtn(TivicGlobal.mClickHomeBtn);

	}

	private void ininBtn(int BtnID) {
		switch (BtnID) {
		case 0:
			recommend_button.setEnabled(false);
			break;
		case 1:
			hotspot_button.setEnabled(false);
			break;
		case 2:
			tieba_button.setEnabled(false);
			break;
		default:
			break;
		}
	}

	private void ininLayout() {
		// 初始化按钮控件

		recommend_button = (Button) findViewById(R.id.recommend_button);
		hotspot_button = (Button) findViewById(R.id.hotspot_button);
		tieba_button = (Button) findViewById(R.id.tieba_button);

		recommend_button.setOnClickListener(topBarBtnClick(recommend_button));
		hotspot_button.setOnClickListener(topBarBtnClick(hotspot_button));
		tieba_button.setOnClickListener(topBarBtnClick(tieba_button));

	}

	/**
	 * 点击home bar中的 推荐, 热点, 贴吧 button
	 * 
	 * @param btn
	 * @return
	 */
	private View.OnClickListener topBarBtnClick(final Button btn) {

		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (btn == recommend_button) {
					recommend_button.setEnabled(false);
//					Intent intent = new Intent(mContext,
//							PushTvAndUGCActivity.class);
//					mContext.startActivity(intent);
//					TivicGlobal.mClickHomeBtn = 0;
				} else {
					recommend_button.setEnabled(true);
				}
				if (btn == hotspot_button) {
					hotspot_button.setEnabled(false);
//					TivicGlobal.mClickHomeBtn = 1;
				} else {
					hotspot_button.setEnabled(true);
				}
				if (btn == tieba_button) {
					tieba_button.setEnabled(false);
//					TivicGlobal.mClickHomeBtn = 2;
//					Intent intent = new Intent(mContext, UGCActivity.class);
//					mContext.startActivity(intent);
				} else {
					tieba_button.setEnabled(true);
				}
			}
		};
	}

}
