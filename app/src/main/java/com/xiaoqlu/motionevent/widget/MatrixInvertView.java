package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaoqlu.motionevent.R;

/**
 * @author zhongyao
 * @date 2019/3/12
 */

public class MatrixInvertView extends View {

    private Matrix mMatrix;
    private Paint mPaint;
    private Bitmap mBitmap;
    private int mViewWidth, mViewHeight;

    public MatrixInvertView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initBitmapAndMatrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }

    private void initBitmapAndMatrix() {
        mMatrix = new Matrix();
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
    }

    @Override
    protected void onDraw(Canvas conDrawanvas) {
        super.onDraw(conDrawanvas);

        //RectF src = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        //RectF dst = new RectF(0, 0, mViewWidth, mViewHeight);
        //
        //mMatrix.setRectToRect(src, dst, ScaleToFit.CENTER);
        //mMatrix.postTranslate(200,200);
        //mMatrix.postSkew(0.5f, 0, 0, -800);
        //mMatrix.postTranslate(0,100);
        //mMatrix.invert(mMatrix);
        conDrawanvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }
}
