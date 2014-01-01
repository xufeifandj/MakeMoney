package com.jesse.makemoney;

import com.actionbarsherlock.view.Menu;
import com.jesse.customLayout.LeftMenuFragmentItem;
import com.jesse.fragment.FrameHome;
import com.jesse.slidingMenu.MenuFragment;
import com.jesse.slidingMenu.MenuFragment.SLMenuListOnItemClickListener;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends SlidingFragmentActivity implements SLMenuListOnItemClickListener{
	private SlidingMenu mSlidingMenu;  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.frame_menu);  		// 默认左侧可滑动区域布局
		mSlidingMenu = getSlidingMenu(); 
		mSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);			// 设置为可左右都滑动
		mSlidingMenu.setSecondaryMenu(R.layout.frame_right_menu);		// 右侧可滑动区域
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);		// 触摸模式
		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);		// 阴影宽度	
		mSlidingMenu.setShadowDrawable(R.drawable.shadow);			// 阴影图片
		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);		// 划开后的sliding宽度
		mSlidingMenu.setFadeDegree(0.35f);
		
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.left_menu, new MenuFragment());
		fragmentTransaction.commit();
	}
	
	public void selectItem(int position, String title) {  
        // update the main content by replacing fragments    
        Fragment fragment = null;    
        switch (position) {    
        case 0:    
        	fragment = new FrameHome();
            break;    
        }    
        
        if (fragment != null) {    
            FragmentManager fragmentManager = getSupportFragmentManager();  
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();    
            // update selected item and title, then close the drawer    
            setTitle(title);  
            mSlidingMenu.showContent();  
        } else {    
            // error in creating fragment    
            Log.e("MainActivity", "Error in creating fragment");    
        }    
    }  
}
