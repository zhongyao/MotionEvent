package com.xiaoqlu.motionevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.xiaoqlu.motionevent.util.Logger;
import com.xiaoqlu.motionevent.widget.TouchButton;

/**
 * 某个view自身的优先级调用：
 * onTouch > onTouchEvent > onLongClick > onClick
 *
 *  onTouch和onTouchEvent有什么区别：
 *  这两个方法都是在View的dispatchTouchEvent中调用的，onTouch优先于onTouchEvent执行。
 *  如果在onTouch方法中通过返回true将事件消费掉，onTouchEvent将不会再执行
 *
 * 1、当onTouch返回true，拦截onTouchEvent、onLongClick、onClick事件
 * 2、onTouch默认返回false，当把onTouchEvent直接返回true，会执行onLongClick、onClick事件（如果已经设置其各自监听的话）。
 * 3、onTouch默认返回false，当把onTouchEvent直接返回false，拦截了onClick、ACTION_MOVE、ACTION_UP事件，事件由Activity本身消费
 * 4、当onLongClick返回true，那么只会单独执行onLongClick事件，但是不会执行onClick事件。
 *
 * @author hongri
 */
public class TouchActivity extends Activity {

    private TouchButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        mButton = (TouchButton)findViewById(R.id.button);

        mButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Logger.d("--onTouch--");
                return false;
            }
        });

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("--onClick--");
            }
        });

        mButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Logger.d("--onLongClick--");
                return false;
            }
        });
    }
}
