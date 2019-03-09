package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaoqlu.motionevent.R;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author zhongyao
 * @date 2019/3/6
 */

public class MatrixSetRectToRectView extends View {

    private Matrix mMatrix;
    private Bitmap mBitmap;
    private Paint mPaint;
    private int mViewWidth, mViewHeight;

    public MatrixSetRectToRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Logger.d("MatrixSetRectToRectView--执行顺序1");
        initBitmaAndMatrix();
    }

    private void initBitmaAndMatrix() {
        mMatrix = new Matrix();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        mPaint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Logger.d("onSizeChanged--执行顺序2");
        mViewWidth = w;
        mViewHeight = h;
    }

    @Override
    protected void onDraw(Canvas conDrawanvas) {
        super.onDraw(conDrawanvas);
        Logger.d("onDraw--执行顺序3");

        RectF src = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        RectF dst = new RectF(0, 0, mViewWidth, mViewHeight);
        mMatrix.setRectToRect(src, dst, ScaleToFit.CENTER);

        conDrawanvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }
}
