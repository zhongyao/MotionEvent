package com.xiaoqlu.motionevent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author zhongyao
 * @date 2019/2/16
 * 自定义 longClick 事件, 思路：
 * 1、定义一个Handler，用来接受消息。
 * 2、触发DOWN事件时，通知定义的Handler，3s后发送一个长按消息事件。
 * 3、handleMessage收到的事件即表示长按事件。
 */

public class CustomLongClickButton extends AppCompatButton {

    private static final String TAG = "CustomLongClickButton--";
    private static final int LONG_CLICK = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == LONG_CLICK) {
                Log.d(TAG, "收到长按事件");
                Toast.makeText(getContext(), "收到长按事件", Toast.LENGTH_LONG).show();
            }
        }
    };


    public CustomLongClickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "ACTION_DOWN");

                if (mHandler != null) {
                    Message msg = Message.obtain();
                    msg.what = LONG_CLICK;
                    mHandler.sendMessageDelayed(msg, 3000);
                }

                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "ACTION_UP");

                if (mHandler != null) {
                    mHandler.removeCallbacksAndMessages(null);
                }
                break;
            default:
                break;
        }
        return true;
    }
}
