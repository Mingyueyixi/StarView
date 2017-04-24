package yue.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import yue.util.StarPathUtil;

/**
 * Created by Yue on 2017/3/29.
 */

public class StarDrawable extends Drawable {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float rotate;
    private int mHormCount;
    private int mStarColor;
    private int mStarSize;
    private int mStrokeWidth;
    /**深度，0~1之间*/
    private float depth = 0;
    private Path starPath;
    private double r;

    public StarDrawable(){
    }

    public StarDrawable(int starColor, int starSize, int strokeWidth, int hormCount,float depth) {
        this(starColor,starSize,strokeWidth,hormCount,depth,0);
    }
    public StarDrawable(int starColor, int starSize, int strokeWidth, int hormCount,float depth,float rotate) {
        this.mStarColor = starColor;
        this.mStarSize = starSize;
        this.mStrokeWidth = strokeWidth;
        this.mHormCount = hormCount;
        this.depth = depth;
        this.rotate = rotate;

        int w = getIntrinsicWidth();
        r = w/2.0;
        starPath = StarPathUtil.linePath(r,hormCount,depth,rotate);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if(starPath == null){
            starPath = StarPathUtil.linePath(r,mHormCount,depth,rotate);
        }
        canvas.drawPath(starPath,mPaint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        mPaint.setAlpha(alpha);
    }

    public float getRotate() {
        return rotate;
    }

    public void setRotate(float rotate) {
        this.rotate = rotate;
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getIntrinsicHeight() {
        return mStarSize+mStrokeWidth;
    }

    @Override
    public int getIntrinsicWidth() {
        return mStarSize+mStrokeWidth;
    }

    @Override
    public int getOpacity() {
        if (mPaint.getXfermode() == null) {
            if (mPaint.getAlpha() == 255) {
                return PixelFormat.OPAQUE;

            } else if (mPaint.getAlpha() == 0) {
                return PixelFormat.TRANSPARENT;//全透明
            }
        }
        //默认支持透明
        return PixelFormat.TRANSLUCENT;
    }
    public int getStarColor() {
        return mStarColor;
    }

    public void setStarColor(int mStarColor) {
        this.mStarColor = mStarColor;
    }

    public float getStarSize() {
        return mStarSize;
    }

    public void setStarSize(int mStarSize) {
        this.mStarSize = mStarSize;
    }

    public int getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(int mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
    }

    public int getHormCount() {
        return mHormCount;
    }

    public void setHormCount(int mHormCount) {
        this.mHormCount = mHormCount;
    }
}
