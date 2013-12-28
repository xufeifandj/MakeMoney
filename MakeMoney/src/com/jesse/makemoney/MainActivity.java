package com.jesse.makemoney;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;

public class MainActivity extends SlidingFragmentActivity {
	private SlidingMenu mSlidingMenu;  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.frame_left_menu);  		// 默认左侧可滑动区域布局
		mSlidingMenu = getSlidingMenu(); 
		mSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);			// 设置为可左右都滑动
		mSlidingMenu.setSecondaryMenu(R.layout.frame_right_menu);		// 右侧可滑动区域
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);		// 触摸模式
		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);		// 阴影宽度	
		mSlidingMenu.setShadowDrawable(R.drawable.shadow);			// 阴影图片
		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);		// 划开后的sliding宽度
		mSlidingMenu.setFadeDegree(0.35f);

	}
}
