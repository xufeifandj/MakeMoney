package com.jesse.slidingMenu;

import java.util.ArrayList;
import com.jesse.customLayout.LeftMenuFragmentItem;
import com.jesse.makemoney.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

public class MenuFragment extends Fragment implements OnClickListener{
	private SLMenuListOnItemClickListener mCallback;  
	private String[] mNavMenuTitles; 
	private TypedArray mNavMenuIconsTypeArray;
	
	private LeftMenuFragmentItem item_1; 
	private LeftMenuFragmentItem item_2; 
	private LeftMenuFragmentItem item_3; 
	private LeftMenuFragmentItem item_4; 
	private LeftMenuFragmentItem item_5; 
	private ArrayList<LeftMenuFragmentItem> itemListArray;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		itemListArray = new ArrayList<LeftMenuFragmentItem>();
	}

	// 首次绘制用户界面的回调方法，必须返回要创建的Fragments 视图UI
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
		View rootView = inflater.inflate(R.layout.frame_left_menu, null);
		setViewResource(rootView);  
        return rootView;  
    }  
	
	// 当Activity中的onCreate方法执行完后调用。
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);            
	}
	
	// activity与fragment之间的通信
	@Override  
    public void onAttach(Activity activity) {  
        try {  
            mCallback = (SLMenuListOnItemClickListener) activity;  
        } catch (ClassCastException e) {  
            throw new ClassCastException(activity.toString()  
                    + " must implement OnResolveTelsCompletedListener");  
        }  
        super.onAttach(activity);  
    }  
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		int position = 0;
		switch (view.getId()) {
			case R.id.item1:
				position = 1;
				break;
			case R.id.item2:
				position = 2;
				break;	
			case R.id.item3:
				position = 3;
				break;
			case R.id.item4:
				position = 4;
				break;	
			case R.id.item5:
				position = 5;
				break;		
			default:
				break;
		}
		if (mCallback != null) {
			mCallback.selectItem(position, mNavMenuTitles[position - 1]);
		}
	}
	
	private void setViewResource(View rootView) {  
		
		item_1 = (LeftMenuFragmentItem) rootView.findViewById(R.id.item1);
		item_2 = (LeftMenuFragmentItem) rootView.findViewById(R.id.item2);
		item_3 = (LeftMenuFragmentItem) rootView.findViewById(R.id.item3);
		item_4 = (LeftMenuFragmentItem) rootView.findViewById(R.id.item4);
		item_5 = (LeftMenuFragmentItem) rootView.findViewById(R.id.item5);
		itemListArray.add(item_1);
		itemListArray.add(item_2);
		itemListArray.add(item_3);
		itemListArray.add(item_4);
		itemListArray.add(item_5);
		for (int i = 0; i < itemListArray.size(); i++) {
			itemListArray.get(i).setOnClickListener(this);
		}
		
        mNavMenuTitles = getResources().getStringArray(R.array.setting);    
        // nav drawer icons from resources    
        mNavMenuIconsTypeArray = getResources().obtainTypedArray(R.array.nav_drawer_icons);    
        
        for (int i = 0; i < itemListArray.size(); i++) {
        	itemListArray.get(i).setImage(mNavMenuIconsTypeArray.getResourceId(i, -1));
        	itemListArray.get(i).setText(mNavMenuTitles[i]);
        }
    }  
	/** 
     * 左侧菜单 点击回调接口 
     */  
	public interface SLMenuListOnItemClickListener{  
        public void selectItem(int position,String title);  
    }
}
