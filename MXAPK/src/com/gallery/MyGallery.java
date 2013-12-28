package com.gallery;

import java.util.Timer;
import java.util.TimerTask;

import com.jesse.mxapk.MxApkActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Gallery;
import android.widget.Toast;

/**
 * @author jie
 * 
 * �Զ���Gallery��ʵ���޹��Թ������Զ���������onTouch�¼��ļ������Ա��ڹر�������
 */
@SuppressLint("HandlerLeak")
public class MyGallery extends Gallery {

	private final Timer timer = new Timer();
	GestureDetector gestureDetector;
	
	public MyGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
		timer.schedule(task, 5000, 5000);
	}

	

	public void setGestureDetector(GestureDetector gestureDetector) {
		this.gestureDetector = gestureDetector;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		int keyCode;
		if (isScrollingLeft(e1, e2)) { 
            keyCode = KeyEvent.KEYCODE_DPAD_LEFT; 
        } else { 
            keyCode = KeyEvent.KEYCODE_DPAD_RIGHT; 
        } 
        onKeyDown(keyCode, null); 
        return true;
	}
	private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) { 
		if(e2.getX() - e1.getX() > 10) {
		   return true;
		} else {
			return false;
		}
		
    } 
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		super.onTouchEvent(ev);
		if (MxApkActivity.slidingDrawer_down.isOpened()) // �رճ���
		{
			MxApkActivity.slidingDrawer_down.animateClose();
		}
		/**** ���ؼ��� *****/
		InputMethodManager keyboard = (InputMethodManager) MyGallery.this
				.getContext().getSystemService(
						MxApkActivity.INPUT_METHOD_SERVICE);
		keyboard.hideSoftInputFromWindow(
				MxApkActivity.search_textview.getWindowToken(), 0);
		return true;
	}
	
	/**��ʱ����ʵ���Զ�����*/
	private final TimerTask task = new TimerTask() {
		public void run() {
			mHandler.sendEmptyMessage(1);
		}
	};


	private final Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				int position = getSelectedItemPosition();
				if (position >= (getCount() - 1)) {
					onKeyDown(KeyEvent.KEYCODE_DPAD_LEFT, null);
				} else {
					onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
				}
				break;
			default:
				break;
			}
		};
	};
	
	public void destroy(){
		timer.cancel();
	}
}