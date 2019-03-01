package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaoqlu.motionevent.R;

/**
 * Created by zhongyao on 2019/2/28.
 */

public class DragView extends View {

    Bitmap bitmap;

    /**
     * 图片所在区域
     */
    RectF mBitmapRectF;

    /**
     * 控制图片的matrix
     */
    Matrix mBitmapMatrix;

    Paint mDefaultPaint = new Paint();
    boolean canDrag = false;
    PointF lastPoint = new PointF(0, 0);

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        BitmapFactory.Options options = new Options();
        options.outHeight = 300;
        options.outWidth = 400;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eye, options);

        mBitmapRectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        mBitmapMatrix = new Matrix();

        mDefaultPaint.setColor(Color.GREEN);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                //如果是第一个手指,且触摸点在图片区域内
                if (event.getPointerId(event.getActionIndex()) == 0 && mBitmapRectF.contains(event.getX(),
                    event.getY())) {
                    canDrag = true;
                    lastPoint.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (canDrag) {
                    int index = event.findPointerIndex(0);
                    mBitmapMatrix.postTranslate(event.getX(index) - lastPoint.x, event.getY(index) - lastPoint.y);
                    lastPoint.set(event.getX(index), event.getY(index));

                    mBitmapRectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    mBitmapMatrix.mapRect(mBitmapRectF);

                    invalidate();
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_UP:
                if (event.getPointerId(event.getActionIndex()) == 0) {
                    canDrag = false;
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, mBitmapMatrix, mDefaultPaint);
    }
}
