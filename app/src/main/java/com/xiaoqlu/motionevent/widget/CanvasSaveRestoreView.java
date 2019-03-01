package com.xiaoqlu.motionevent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaoqlu.motionevent.util.Logger;

/**
 * @author zhongyao
 * @date 2019/3/1
 * 参考：
 * https://wkkyo.iteye.com/blog/2279387
 *
 * 注意:
 * canvas.rotate(90, mWidth / 2, mWidth / 2)
 * 导致的旋转不是画布的旋转，是画布坐标的旋转
 */

public class CanvasSaveRestoreView extends View {

    private final int mScreenWidht = 1440, mScreenHeight = 2368;
    private int mWidth, mHeight;
    private Paint mPaint;

    public CanvasSaveRestoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        Logger.d("mWidth:" + mWidth + " mHeight:" + mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(90, mWidth / 2, mWidth / 2);
        canvas.drawCircle(mWidth / 2, 50, 50, mPaint);

        canvas.restore();

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mWidth - 50, 50, 50, mPaint);

    }
}
