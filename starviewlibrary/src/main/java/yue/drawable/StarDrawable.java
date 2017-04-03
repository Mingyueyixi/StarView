package yue.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Yue on 2017/3/29.
 */

public class StarDrawable extends Drawable {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mStarColor;
    private int mStarSize;
    private int mStrokeWidth;
    private int mHormCount;
    /**深度，0~1之间*/
    private double depth = 0;
//    private Bitmap dstBitmap;
//    private Bitmap srcBitmap;
    private Path starPath;
    private double r;
//    private Bitmap bit;

    public StarDrawable(){
    }

    public StarDrawable(int starColor, int starSize, int strokeWidth, int hormCount,@FloatRange(from=0,to =1) double depth) {
        this.mStarColor = starColor;
        this.mStarSize = starSize;
        this.mStrokeWidth = strokeWidth;
        this.mHormCount = hormCount;
        this.depth = depth;

        linePath();
    }
//    private Bitmap factBitmap;
//    private void factBitmap(){
//        if (getStarSize()>0) {
////            Canvas canvas = new Canvas();
//            mPaint.setColor(mStarColor);
//
//            float r = getIntrinsicWidth() / 2.0f;
//            //f点坐落在弧上。
//            double sArf = Math.PI * (90 - 180.0 / mHormCount) / 180;//角arf的弧度
//            double lRf = 2 * r * Math.sin(Math.PI / mHormCount);//圆内接正多边形边长公式2r*sin(180/n);
//            double fX = lRf * Math.sin(sArf);
//            double fY = lRf * Math.cos(sArf);
//
//            //P点坐落在as直线上
//            double sArs = sArf;//两角实为同一角,所以弧度相同
//            double sPrs = depth * sArs;//角prs的弧度，depth*角度，而不是直线长度，否则会导致计算量剧增。
//            double xLen = lRf / 2.0;
//            double pr = xLen / Math.cos(sPrs);
////            double ps = pr*Math.sin(sPrs);
//
//            double sPra = (1.0 - depth) * sArs;//角pra的弧度。
//            double pX = pr * Math.sin(sPra);
//            double pY = pr * Math.cos(sPra);
//
//            Log.e("测试", xLen + "--" + pr + "" + fX + "--" + fY + "--" + pX + "--" + pY);
//            Path path = new Path();
//            path.moveTo(0, 0);//原点
//
//
//
//            path.lineTo((float) pX, (float) pY);//p点
//            path.lineTo((float) fX, (float) fY);//f点
//            path.lineTo(0,r);
//            path.close();
//
//            factBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            Canvas c = new Canvas(factBitmap);
//            c.translate(r,0);
//            c.drawPath(path, mPaint);
//
//        }
//    }

    /**
     * 连接路径
     */
    private  void linePath(){

        int w = getIntrinsicWidth();
        int h = getIntrinsicHeight();
        r = w>h ? (h/2.0) : (w/2.0);

        double sOrs = Math.PI * (90 - 180.0 / mHormCount) / 180;//角arf的弧度
        double sPro = (1.0 - depth) * sOrs;//角pra的弧度
        double sPrs = depth*sOrs;//角prs的弧度

        //圆内接正多边形边长公式2r*sin(180/n);rs = 边长/2
        double lRs = r * Math.sin(Math.PI / mHormCount);
        double pr = lRs/Math.cos(sPrs);
        //p点坐标
        double pX = pr * Math.sin(sPro);
        double pY = pr * Math.cos(sPro);

        starPath = new Path();
        starPath.moveTo(0,0);
        /**
         * 已知圆心o（a,b）,R（x,y）,求R点顺时针移动c弧度后的坐标
         * x'=(x-a)cos(-c)-(y-b)sin(-c)+a
         * y'=(y-b)cos(-c)+(x-a)sin(-c)+b
         *
         * 此处坐标非正常坐标，为逆时针旋转，a=0,b=r,故：
         * x' = x*cos(c) - (y-r)sin(c)
         * y' = (y-r)cos(c) + x*sin(c)+r
         */
        //循环求出每旋转c==PI*(360/mHormCount)/180弧度后r点和p点的坐标，并构建为路径
        for (int i = 0;i<mHormCount;i++){
            double c = i*2*Math.PI/mHormCount;
            double sin_c = Math.sin(c);
            double cos_c = Math.cos(c);

            //r(0,0)>>R(x,y)
            float rX2 = (float) (r*sin_c);
            float rY2 = (float) (-r*cos_c + r);
            //p(pX,pY)>>R(x,y)
            float pX2 = (float) (pX*cos_c - (pY - r)*sin_c);
            float pY2 = (float) ((pY - r)*cos_c + pX*sin_c +r);

            starPath.lineTo(rX2,rY2);
            starPath.lineTo(pX2,pY2);

            Log.e("测试","r("+rX2+","+rY2+") , p("+pX2+","+pY2+")");
        }

        starPath.close();
//        bit = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bit);
//        canvas.translate((float)r, (float)r);
//        canvas.drawPath(starPath,mPaint);

    }
//    private void flushBitmap(){
//        if (getStarSize()>0){
////            Canvas canvas = new Canvas();
//            mPaint.setColor(mStarColor);
//
//            float r = getIntrinsicWidth()/2.0f;
////            canvas.drawCircle(bounds.centerX(),bounds.centerY(),r,mPaint);
//
//            RectF rect = new RectF(0,0,getIntrinsicWidth(),getIntrinsicHeight());
////            canvas.drawArc(rect,-90,360/mHormCount,false,mPaint);
////            canvas.drawArc(rect,-90,360/mHormCount,true,mPaint);
//            dstBitmap = Bitmap.createBitmap(getIntrinsicWidth(),getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            Canvas dstCanvas = new Canvas(dstBitmap);
//            dstCanvas.drawArc(rect,-90,360/mHormCount,true,mPaint);
//
////            canvas.drawBitmap(dstBitmap,0,0,mPaint);
////            canvas.saveLayer(0, 0,getIntrinsicWidth(),getIntrinsicHeight(), null, Canvas.MATRIX_SAVE_FLAG |
////                    Canvas.CLIP_SAVE_FLAG |
////                    Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
////                    Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
////                    Canvas.CLIP_TO_LAYER_SAVE_FLAG);
////            canvas.translate(r,0);//坐标系平移
//
////            double coor = (360.0/mHormCount)/2.0;//内接正多边形角度的一半==角rsc
////            double lCoor = Math.PI/mHormCount;//弧度
//
////            double xLen =  r * Math.sin(lCoor);//圆内接正多边形边长公式：2R*sin（180/n）,此处Math.sin单位弧度,1弧度=pi/180
////            double yLen = r * Math.cos(lCoor);//==as
////
////            double sX = xLen * Math.cos(lCoor);//s点坐标x==sc
////            double sY = xLen * Math.sin(lCoor);//s点坐标y==rc
//
///* 坐标方程不适用，计算非常为复杂
//            直线方程一般式：aX + bY + c = 0
//            a = Y2 - Y1
//            b = X1 - X2
//            c = X2*Y1 - X1*Y2
//            a（0,r）作为第一点，s(sx,sy)作为第二点，故可求出as的直线方程式
//            */
////            double a = sY - r;
////            double b = 0 - sX;
////            double c = sX*r + 0*sY;
//
//
//            //f点坐落在弧上。
//            double sArf = Math.PI*(90-180.0/mHormCount)/180;//角arf的弧度
//            double lRf = 2*r*Math.sin(Math.PI/mHormCount);//圆内接正多边形边长公式r*sin(180/n);
//            double fX = lRf*Math.sin(sArf);
//            double fY = lRf*Math.cos(sArf);
//
//            //P点坐落在as直线上
//            double sArs = sArf;//两角实为同一角,所以弧度相同
//            double sPrs = depth*sArs;//角prs的弧度，depth*角度，而不是直线长度，否则会导致计算量剧增。
//            double xLen = lRf/2.0;
//            double pr = xLen/Math.cos(sPrs);
////            double ps = pr*Math.sin(sPrs);
//
//            double sPra = (1.0-depth)*sArs;//角pra的弧度。
//            double pX = pr * Math.sin(sPra);
//            double pY = pr * Math.cos(sPra);
//
//            Log.e("测试",xLen+"--"+pr+""+fX+"--"+fY+"--"+pX+"--"+pY);
//            Path path = new Path();
//            path.moveTo(0,0);
//            path.lineTo((float)fX, (float)fY);
//            path.lineTo((float)pX,(float)pY);
//            path.close();
//
//            srcBitmap = Bitmap.createBitmap(getIntrinsicWidth(),getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            Canvas c = new Canvas(srcBitmap);
//            c.drawPath(path,mPaint);
//
////            Canvas canvas = new Canvas();
////            int layerId = canvas.saveLayer(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), null, Canvas.ALL_SAVE_FLAG);
////            canvas.drawBitmap(dstBitmap,0,0,mPaint);
////            canvas.translate(getIntrinsicWidth()/2.0f,0);
////
////            Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
////            mPaint.setXfermode(xfermode);
////            canvas.drawBitmap(srcBitmap,0,0,mPaint);
////
////            canvas.restoreToCount(layerId);
//        }
//    }

    @Override
    public void draw(@NonNull Canvas canvas) {
//旋转绘制的方法可能存在误差而导致连接之间有空隙，因此，应选择绘制路径的方式
//        for (int i= 0;i<mHormCount;i++){
//            canvas.rotate(360f/mHormCount,getIntrinsicWidth()/2,getIntrinsicHeight()/2);
//            canvas.drawBitmap(factBitmap,0,0,mPaint);
//        }
//        canvas.drawBitmap(factBitmap,0,0,mPaint);

//        canvas.drawPath(starPath,mPaint);
//        canvas.drawBitmap(bit,0,0,mPaint);
        canvas.translate(getIntrinsicWidth()/2f,0);
        canvas.drawPath(starPath,mPaint);
    }


    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        mPaint.setAlpha(alpha);
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
