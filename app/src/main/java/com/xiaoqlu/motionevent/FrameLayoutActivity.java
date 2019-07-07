package com.xiaoqlu.motionevent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * FrameLayout相关事件的透传
 *
 * FrameLayout上下两层View分别是A和B，如何实现点击A的时候，让B触发事件：
 * 将View A设置：tvA.setClickable(false);
 */
public class FrameLayoutActivity extends Activity {

    private Button btnA, btnB;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        btnA = (Button)findViewById(R.id.btnA);
        btnB = (Button)findViewById(R.id.btnB);

        //方法1
        btnA.setClickable(false);

        //方法2
        //btnA.setOnTouchListener(new OnTouchListener() {
        //    @Override
        //    public boolean onTouch(View v, MotionEvent event) {
        //        return true;
        //    }
        //});


        btnB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("tvB###onClick");
            }
        });

    }
}
