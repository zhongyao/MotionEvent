package com.xiaoqlu.motionevent;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by zhongyao on 2021/2/28.
 * 在onTouchEvent中自定义长按事件
 */
public class CustomLongClickActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_long_click);
    }
}