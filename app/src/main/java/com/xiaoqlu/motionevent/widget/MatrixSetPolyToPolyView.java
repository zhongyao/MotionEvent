package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaoqlu.motionevent.R;

/**
 * @author zhongyao
 * @date 2019/3/6
 */

public class MatrixSetPolyToPolyView extends View {

    private Matrix mMatrix;
    private Bitmap mBitmap;
    private Paint mPaint;

    public MatrixSetPolyToPolyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initBitmapAndMatrix();
    }

    private void initBitmapAndMatrix() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mMatrix = new Matrix();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);

        float[] src = new float[] {0, 0, mBitmap.getWidth(), 0, mBitmap.getWidth(), mBitmap.getHeight(), 0,
            mBitmap.getHeight()};
        float[] dst = new float[] {0, 0, mBitmap.getWidth(), 100, mBitmap.getWidth(), mBitmap.getHeight() - 100, 0,
            mBitmap.getHeight()};
        //多边形变换
        mMatrix.setPolyToPoly(src, 0, dst, 0, 4);
        mMatrix.postTranslate(0, 200);

    }

    @Override
    protected void onDraw(Canvas conDrawanvas) {
        super.onDraw(conDrawanvas);
        conDrawanvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }
}
