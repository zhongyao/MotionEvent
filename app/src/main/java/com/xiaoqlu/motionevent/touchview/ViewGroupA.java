package com.xiaoqlu.motionevent.touchview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author hongri
 */
public class ViewGroupA extends LinearLayout {

    private final String TAG = "ViewGroupA";

    public ViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "--dispatchTouchEvent--DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "--dispatchTouchEvent--MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "--dispatchTouchEvent--UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }*/

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "--onInterceptTouchEvent--DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "--onInterceptTouchEvent--MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "--onInterceptTouchEvent--UP");
                break;
            default:
                break;
        }
        //此处有修改
        if (action == MotionEvent.ACTION_DOWN) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "--onTouchEvent--DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "--onTouchEvent--MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "--onTouchEvent--UP");
                break;
            default:
                break;
        }
        //此处有修改
        return true;
    }
}