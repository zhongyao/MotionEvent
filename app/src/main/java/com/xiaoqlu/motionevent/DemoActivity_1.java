package com.xiaoqlu.motionevent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * 滑动冲突场景Activity
 */
public class DemoActivity_1 extends Activity {

    //    private ListView lv1,lv2,lv3;
    private MyListView lv1, lv2, lv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_1);

//        lv1 = (ListView) findViewById(lv1);
//        lv2 = (ListView) findViewById(lv2);
//        lv3 = (ListView) findViewById(lv3);

        lv1 = (MyListView) findViewById(R.id.lv1);
        lv2 = (MyListView) findViewById(R.id.lv2);
        lv3 = (MyListView) findViewById(R.id.lv3);
        initData();
    }

    private void initData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("android " + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.content_list_item, R.id.name, datas);
        lv1.setAdapter(adapter);
        lv2.setAdapter(adapter);
        lv3.setAdapter(adapter);
    }
}
