package com.xiaoqlu.motionevent;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * 事件分发机制基本原理概述:
 * 顶层View先逐层分发事件、再逐层选择消费事件、如果最底层View未消费事件，则从最底层开始逐步上报，最终可形成一个循环事件链路.
 *
 * 具体事件分发流程如下：
 * --EventActivity 调用dispatchTouchEvent分发事件(if返回true，该事件分发到此结束) if返回false(默认)--继续往下分发事件至ViewGroupA
 * --ViewGroupA 调用dispatchTouchEvent分发事件(if返回true，该事件分发到此结束) if返回false(默认)--调用onInterceptTouchEvent事件(if返回true，则调用自己的onTouchEvent来进行消费) if返回false--继续往下分发事件至ViewB
 * --ViewB 调用dispatchTouchEvent分发事件(if返回true，该事件分发到此结束) if返回false(默认)--调用onTouchEvent事件（如果返回true，则在此 ViewB 消费该事件）if返回false--开始上报至ViewGroupA
 * --ViewGroupA 中调用onTouchEvent事件（if返回true，则在此 ViewGroupA 消费该事件） if返回false--上报至EventActivity
 * --EventActivity 中调用onTouchEvent事件，无论返回true or false都最终由该 EventActivity 消费该事件。
 *
 * 遍历是为了寻找真正消费事件的View(ViewGroup):
 * 当EventActivity收到Touch事件时，将遍历子View进行Down事件的分发，ViewGroup的遍历可以看成是递归的。分发的目的是为了能够真正找到要消费该事件的View。
 * 当已经找到消费该事件的ViewGroup之后，该ViewGroup的子View将不会再收到Down事件的触发，即递归遍历只走一遍，找到能消费此事件的ViewGroup(or View)为止。
 *
 * 分发时onInterceptTouchEvent事件并不一定会调用：
 * 当已经确认(如ViewGroupA)已经拦截并消费了该事件，那么以后不会在调用其onInterceptTouchEvent方法(在已经拦截并消费的情况下，就没有必要每次都询问了)，但是dispatchTouchEvent无论如何是每次都需要调用的。
 *
 * 参考：
 * https://blog.csdn.net/guolin_blog/article/details/9097463【郭霖】
 * https://www.jianshu.com/p/38015afcdb58
 * http://wuxiaolong.me/2015/12/19/MotionEvent/
 *
 * @author zhongyao
 */
public class EventActivity extends Activity {

    private static final String TAG = "EventActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        setContentView(R.layout.main);
    }

    /*@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
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
    public void onUserInteraction() {
        super.onUserInteraction();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
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
        return super.onTouchEvent(event);
    }
}
