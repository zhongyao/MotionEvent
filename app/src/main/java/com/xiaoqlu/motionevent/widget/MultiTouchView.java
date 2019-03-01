package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhongyao on 2019/2/28.
 * 绘制出第二个手指第位置
 */

public class MultiTouchView extends View {
    String TAG = "yao";
    Paint mDeafultPaint = new Paint();
    float mViewWidth = 1920;
    float mViewHeight = 2560;

    // 用于判断第2个手指是否存在
    boolean haveSecondPoint = false;

    // 记录第2个手指第位置
    PointF point = new PointF(0, 0);

    public MultiTouchView(Context context) {
        this(context, null);
    }

    public MultiTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mDeafultPaint.setAntiAlias(true);
        mDeafultPaint.setTextAlign(Paint.Align.CENTER);
        mDeafultPaint.setTextSize(30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_POINTER_DOWN:
                // 判断是否是第2个手指按下
                if (event.getPointerId(index) == 1) {
                    haveSecondPoint = true;
                    point.set(event.getY(), event.getX());
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                // 判断抬起的手指是否是第2个
                if (event.getPointerId(index) == 1) {
                    haveSecondPoint = false;
                    point.set(0, 0);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (haveSecondPoint) {
                    // 通过 pointerId 来获取 pointerIndex
                    int pointerIndex = event.findPointerIndex(1);
                    // 通过 pointerIndex 来取出对应的坐标
                    point.set(event.getX(pointerIndex), event.getY(pointerIndex));
                }
                break;

            default:
                break;
        }

        invalidate();   // 刷新

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(mViewWidth / 2, mViewHeight / 2);
        canvas.drawText("追踪第2个按下手指的位置", 0, 0, mDeafultPaint);
        canvas.restore();

        // 如果屏幕上有第2个手指则绘制出来其位置
        if (haveSecondPoint) {
            canvas.drawCircle(point.x, point.y, 50, mDeafultPaint);
        }
    }
}
