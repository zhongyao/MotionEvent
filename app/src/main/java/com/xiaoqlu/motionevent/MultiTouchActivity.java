package com.xiaoqlu.motionevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/**
 * @author hongri
 * 参考：http://www.gcssloop.com/customview/multi-touch
 */
public class MultiTouchActivity extends Activity /*implements OnTouchListener*/ {

    //private MultiTouchView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_multi_touch);

        //tv = (MultiTouchView)findViewById(R.id.tv);
        //tv.setOnTouchListener(this);
    }

    //@Override
    //public boolean onTouchEvent(MotionEvent event) {
    //    switch (event.getAction()){
    //    }
    //    return super.onTouchEvent(event);
    //}

    //@Override
    //public boolean onTouch(View v, MotionEvent event) {
    //    int pointerCount = event.getPointerCount();
    //    for (int i = 0; i < pointerCount; i++) {
    //        int pointerId = event.getPointerId(i);
    //        int pointerIndex = event.findPointerIndex(pointerId);
    //        Logger.d("pointerId:" + pointerId + " pointerIndex:" + pointerIndex);
    //    }
    //    return false;
    //}
}
