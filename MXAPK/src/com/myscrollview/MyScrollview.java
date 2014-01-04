package com.myscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;

import com.jesse.mxapk.MxApkActivity;
/**
 * @author jie
 *
 */
public class MyScrollview extends ScrollView {

	public MyScrollview(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		super.onTouchEvent(ev);
		if (MxApkActivity.slidingDrawer_down.isOpened())// �رճ���
		{
			MxApkActivity.slidingDrawer_down.animateClose();
		}
		/**** ���ؼ��� *****/
		InputMethodManager keyboard = (InputMethodManager) MyScrollview.this
				.getContext().getSystemService(
						MxApkActivity.INPUT_METHOD_SERVICE);
		keyboard.hideSoftInputFromWindow(
				MxApkActivity.search_textview.getWindowToken(), 0);
		return true;
	}
}
