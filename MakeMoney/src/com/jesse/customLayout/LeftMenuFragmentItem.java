package com.jesse.customLayout;

import com.jesse.makemoney.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LeftMenuFragmentItem extends RelativeLayout {

	private ImageView imageView;
	private TextView textView;
	
	public LeftMenuFragmentItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public LeftMenuFragmentItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.frame_left_menu_item, this);
        imageView=(ImageView) findViewById(R.id.image);
        textView=(TextView)findViewById(R.id.text);
    }

	public void setImage(int resId) {
		imageView.setImageResource(resId);
	}
	
	public void setText(String text) {
		textView.setText(text);
	}
}
