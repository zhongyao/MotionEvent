package com.xiaoqlu.motionevent.touchview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.xiaoqlu.motionevent.MotionEventActivity;

/**
 * @author hongri
 */
public class MyTextView3 extends AppCompatTextView implements View.OnClickListener {
    private final String TAG = "MyTextView3---------";

    public MyTextView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, TAG);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--dispatchTouchEvent action:ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--dispatchTouchEvent action:ACTION_MOVE");
                break;

            case MotionEvent.ACTION_UP:
                Log.d(MotionEventActivity.TAG, TAG
                    + "--dispatchTouchEvent action:ACTION_UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
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

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick");
    }

    public boolean onLongClick(View v) {
        Log.d(TAG, "onLongClick");
        return false;
    }
}