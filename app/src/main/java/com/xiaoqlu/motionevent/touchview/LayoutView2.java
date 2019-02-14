package com.xiaoqlu.motionevent.touchview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.xiaoqlu.motionevent.MotionEventActivity;

/**
 * @author hongri
 */
public class LayoutView2 extends LinearLayout {
    private final String TAG = "LayoutView2------";
    private boolean mIsBeingDragged = false;

    public LayoutView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, TAG);
    }
    /*@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	int action = ev.getAction();
    	switch (action) {
		case MotionEvent.ACTION_DOWN:
			Log.d(MotionEventActivity.TAG,TAG+"--dispatchTouchEvent action:ACTION_DOWN");
			break;
			
		case MotionEvent.ACTION_MOVE:
			Log.d(MotionEventActivity.TAG,TAG+"--dispatchTouchEvent action:ACTION_MOVE");
			break;
			
		case MotionEvent.ACTION_UP:
			Log.d(MotionEventActivity.TAG,TAG+"--dispatchTouchEvent action:ACTION_UP");
			break;

			
		default:
			break;
		}
    	return super.dispatchTouchEvent(ev);
    }*/

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        final int action = ev.getAction();
        /**
         * 当拖拽的时候希望拦截此事件时，可以用如下方法
         */
        //if (action != MotionEvent.ACTION_DOWN && mIsBeingDragged) {
        //    return true;
        //}
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mIsBeingDragged = false;
                Log.d(MotionEventActivity.TAG, TAG + "--onInterceptTouchEvent action:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                mIsBeingDragged = true;
                Log.d(MotionEventActivity.TAG, TAG + "--onInterceptTouchEvent action:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                Log.d(MotionEventActivity.TAG, TAG + "--onInterceptTouchEvent action:ACTION_UP");
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d(MotionEventActivity.TAG, TAG + "--onTouchEvent action:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MotionEventActivity.TAG, TAG + "--onTouchEvent action:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MotionEventActivity.TAG, TAG + "--onTouchEvent action:ACTION_UP");
                break;
            default:
                break;
        }
        return false;
    }
}

