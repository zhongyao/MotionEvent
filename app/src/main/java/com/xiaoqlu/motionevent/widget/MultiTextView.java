package com.xiaoqlu.motionevent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author zhongyao
 * @date 2019/2/26
 */

@SuppressLint("AppCompatCustomView")
public class MultiTextView extends TextView {

    private int mActivePointerId;

    public MultiTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    /**
     * getActionIndex()轻松获取到事件的索引（index），index变化有如下特点：
     * 1、从0开始，自动增长
     * 2、如果之前落下的手指抬起，后面手指的index会减小
     * 3、index变化趋向于第一次落下的数值：
     *      即手指抬起时的index会趋向于和按下时相同，虽然在手指数量不足时，index会变小，但是当多指变动时，index会趋向于和按下时一样。
     * 4、对move事件无效
     *      即在move时，不论你移动哪一个手指，使用getActionIndex()获取到的始终是0.
     *
     *
     *
     * getPointerId(int pointerIndex) 获取当前某个手指的id
     * findPointerIndex(int pointerId) 获取当前pointerId的index
     * getPointerCount()获取当前手指数
     *
     *
     * pointerId与index最大的区别就是pointerId是不变的，始终未第一次落下时生成的数值，不会受到其他手指抬起和落下的影响。
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        Logger.d("pointerCount:" + pointerCount);

        if (pointerCount > 1) {
            Logger.d("多点触控");
        } else {
            Logger.d("单点触控");
        }

        //for (int i = 0; i < pointerCount; i++) {
        //    int pointerId = event.getPointerId(i);
        //    int pointerIndex = event.findPointerIndex(pointerId);
        //    Logger.d("pointerId:" + pointerId + " pointerIndex:" + pointerIndex);
        //}



        int index = MotionEventCompat.getActionIndex(event);
        Logger.d("index:" + index);

        mActivePointerId = event.getPointerId(0);
        int mPointerIndex = event.findPointerIndex(mActivePointerId);
        //Logger.d("mActivePointerId:" + mActivePointerId + " mPointerIndex:" + mPointerIndex);
        float x = event.getX(mPointerIndex);
        float y = event.getY(mPointerIndex);
        //Logger.d("x:" + x + " y:" + y);

        //用于普通的触摸事件（单点触控）
        //int action = event.getAction();

        //用于多点触控
        int actionMasked = MotionEventCompat.getActionMasked(event);
        Logger.d("onTouchEvent--action is:" + actionToString(actionMasked));
        switch (actionMasked) {
            //0
            case MotionEvent.ACTION_DOWN:

                break;
            //2
            case MotionEvent.ACTION_MOVE:

                break;
            //1
            case MotionEvent.ACTION_UP:

                break;
            //5
            case MotionEvent.ACTION_POINTER_DOWN:

                break;
            //6
            case MotionEvent.ACTION_POINTER_UP:

                break;
            default:
                break;
        }

        return true;
    }

    // Given an action int, returns a string description
    public static String actionToString(int action) {
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                return "Down";
            case MotionEvent.ACTION_MOVE:
                return "Move";
            case MotionEvent.ACTION_POINTER_DOWN:
                return "Pointer Down";
            case MotionEvent.ACTION_UP:
                return "Up";
            case MotionEvent.ACTION_POINTER_UP:
                return "Pointer Up";
            case MotionEvent.ACTION_OUTSIDE:
                return "Outside";
            case MotionEvent.ACTION_CANCEL:
                return "Cancel";
            default:
                break;
        }
        return "";
    }
}
