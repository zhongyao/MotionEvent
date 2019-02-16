package com.xiaoqlu.motionevent.touchview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author hongri
 */
public class MyTextView3 extends AppCompatTextView{
    private final String TAG = "MyTextView--3---------";

    public MyTextView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, TAG);
    }

    /*@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "--dispatchTouchEvent action:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "--dispatchTouchEvent action:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "--dispatchTouchEvent action:ACTION_UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "--onTouchEvent action:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "--onTouchEvent action:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "--onTouchEvent action:ACTION_UP");
                break;
            default:
                break;
        }
        return false;
    }
}