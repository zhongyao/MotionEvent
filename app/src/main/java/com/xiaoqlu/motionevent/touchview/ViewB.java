package com.xiaoqlu.motionevent.touchview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author hongri
 */
public class ViewB extends AppCompatTextView {
    private final String TAG = "ViewB";
    private float mDragDistance;
    private float mLastTouchY;

    public ViewB(Context context, AttributeSet attrs) {
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
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "--onTouchEvent--DOWN");
                mLastTouchY = ev.getY();
                //此处有修改
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "--onTouchEvent--MOVE");
                mDragDistance = ev.getY() - mLastTouchY;
                //此处有修改
                /**
                 * 当Y轴滑动距离大于20px时，由父类拦截事件
                 */
                if (Math.abs(mDragDistance) > 20) {
                    Logger.d(TAG + "--允许父类拦截--");
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "--onTouchEvent--UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Logger.d(TAG + "--onTouchEvent--CANCEL");
                break;
            default:
                break;
        }
        return true;
    }
}