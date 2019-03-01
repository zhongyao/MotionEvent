package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.xiaoqlu.motionevent.R;
import com.xiaoqlu.motionevent.util.Logger;

import static android.view.ScaleGestureDetector.*;

/**
 * @author zhongyao
 * @date 2019/3/1
 */

public class ScaleView extends View {

    private static final String TAG = ScaleView.class.getSimpleName() + "---";
    private ScaleGestureDetector mGestureDetector;
    private Context mContext;
    private Bitmap mBitmap;
    private Matrix mBitmapMatrix;
    private Paint mPaint;

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        initView();

        initDetector();

    }

    private void initView() {
        BitmapFactory.Options mOption = new Options();
        mOption.outWidth = 200;
        mOption.outHeight = 150;
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eye, mOption);

        mBitmapMatrix = new Matrix();

        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
    }

    private void initDetector() {
        mGestureDetector = new ScaleGestureDetector(mContext, new OnScaleGestureListener() {

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                //缩放因子
                Logger.d(TAG + "scale=" + detector.getScaleFactor());
                //缩放中心X坐标
                Logger.d(TAG + "focusX=" + detector.getFocusX());
                //缩放中心Y坐标
                Logger.d(TAG + "focusY=" + detector.getFocusY());

                mBitmapMatrix.postScale(detector.getScaleFactor(), detector.getScaleFactor(), detector.getFocusX(),
                    detector.getFocusY());
                invalidate();

                return true;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, mBitmapMatrix, mPaint);
    }
}
