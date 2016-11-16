package com.xiaoqlu.motionevent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 事件分发机制（先分发事件、再消费事件、最后可形成一个循环--这种情况就是最外层的view分发事件，但是没有子view消费的话，最后还是有最外层的view来消费的情况）：
 * 三层View，从外到内依次为： LayoutView1、LayoutView2、MyTextView。
 * 分别使用view1、view2、view3代替。
 * 最外层view1--调用dispatchTouchEvent分发事件--onInterceptTouchEvent返回false--继续往下分发事件
 * --view2调用dispatchTouchEvent分发事件--onInterceptTouchEvent返回false--继续往下分发事件
 * --view3调用dispatchTouchEvent分发事件--调用onTouchEvent事件 if返回false（如果返回true，则在此view3消费该事件）
 * --返回到view2中调用onTouchEvent事件 if返回false（如果true，则在此view2消费该事件）
 * --返回到view1中调用onTouchEvent事件 if返回false（如果true，则在此view1消费该事件）
 * --返回到MotionEventActivity中调用onTouchEvent事件，无论返回true or false都最终由该Activity消费该事件。
 * 
 * @author zhongyao
 *
 */

/**
 * 某个view自身的优先级调用：
 *
 * onTouchListener > onTouchEvent > onClickListener
 */
public class MotionEventTestActivity extends Activity implements View.OnClickListener{

    public static final String TAG = "yao";
    private View view;
    private View view_activityset;
    private View view1,view2;
    private TextView tv;
    private Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initData();
     }

    private void initData() {
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);


        view = getWindow().getDecorView();
        view_activityset = ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        Log.d(TAG,"view:"+view);
        Log.d(TAG,"view_activityset:"+view_activityset);
        /**
         * 给View设置的OnTouchListener其优先级比onTouchEvent的高：
         *
         * 如果onTouch的返回值为false，则当前View的onTouchEvent方法会被调用；
         * 如果返回true，那么onTouchEvent事件将不会被调用。
         */
//        tv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d(TAG,"Activity--tv-onTouch");
//                return false;
//            }
//        });

        /**
         * OnClickListener其优先级最低，即处于事件传递的尾端
         */
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Activity--tv--onClick");
            }
        });

//        view1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d(TAG,"Activity--onTouch");
//                return false;
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"Activity--dispatchTouchEvent-DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"Activity--dispatchTouchEvent-MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG,"Activity--dispatchTouchEvent-UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        Log.d(TAG,"activity--onUserInteraction");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	Log.d(TAG, "Activity--onTouchEvent");
    	 int action = event.getAction();
         switch(action){
         case MotionEvent.ACTION_DOWN:
             Log.d(TAG,TAG+"Activity--onTouchEvent action:ACTION_DOWN");
             break;
         case MotionEvent.ACTION_MOVE:
             Log.d(TAG,TAG+"Activity--onTouchEvent action:ACTION_MOVE");
             break;
         case MotionEvent.ACTION_UP:
             Log.d(TAG,TAG+"Activity--onTouchEvent action:ACTION_UP");
             break;
         case MotionEvent.ACTION_CANCEL:
             Log.d(TAG,TAG+"Activity--onTouchEvent action:ACTION_CANCEL");
             break;
         }     
    	return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                Intent intent = new Intent(this,DemoActivity_1.class);
                startActivity(intent);
                break;
        }
    }
}
