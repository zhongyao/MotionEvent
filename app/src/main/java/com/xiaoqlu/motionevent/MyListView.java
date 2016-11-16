package com.xiaoqlu.motionevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * @author：zhongyao on 2016/11/16 18:55
 * @description:滑动事件内部拦截
 */

public class MyListView extends ListView {

    private static final String TAG = "ListViewEx";
    private ScrollerLayout scrollerLayout;
    //分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scrollerLayout = new ScrollerLayout(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                scrollerLayout.requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaxX = x - mLastX;
                int deltaxY = y - mLastY;
                if (Math.abs(deltaxX) > Math.abs(deltaxY)){
                    scrollerLayout.requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }
}
