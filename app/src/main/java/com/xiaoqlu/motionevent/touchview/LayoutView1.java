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
public class LayoutView1 extends LinearLayout {

    private final String TAG = "LayoutView1---";

    public LayoutView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, TAG);
    }

	/*
     * @Override public boolean dispatchTouchEvent(MotionEvent ev) { int action
	 * = ev.getAction();
	 * 
	 * switch (action) {
	 * 
	 * case MotionEvent.ACTION_DOWN: Log.d(MotionEventActivity.TAG, TAG +
	 * "--dispatchTouchEvent action:ACTION_DOWN");
	 * 
	 * break;
	 * 
	 * case MotionEvent.ACTION_MOVE:
	 * 
	 * Log.d(MotionEventActivity.TAG, TAG +
	 * "--dispatchTouchEvent action:ACTION_MOVE");
	 * 
	 * break;
	 * 
	 * case MotionEvent.ACTION_UP:
	 * 
	 * Log.d(MotionEventActivity.TAG, TAG +
	 * "--dispatchTouchEvent action:ACTION_UP");
	 * 
	 * break;
	 *
	 * 
	 * } System.out.println(super.dispatchTouchEvent(ev)); return
	 * super.dispatchTouchEvent(ev); }
	 */

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--onInterceptTouchEvent action:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--onInterceptTouchEvent action:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--onInterceptTouchEvent action:ACTION_UP");
                break;

            default:
                break;
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--onTouchEvent action:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--onTouchEvent action:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--onTouchEvent action:ACTION_UP");
                break;
            default:
                break;
        }
        return false;
    }
}