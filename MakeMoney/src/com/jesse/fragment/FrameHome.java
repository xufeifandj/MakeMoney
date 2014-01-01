package com.jesse.fragment;

import com.jesse.makemoney.R;
import com.jesse.makemoney.R.layout;
import com.jesse.makemoney.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class FrameHome extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// 首次绘制用户界面的回调方法，必须返回要创建的Fragments 视图UI
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        return inflater.inflate(R.layout.frame_home, null);  
    }  
}
