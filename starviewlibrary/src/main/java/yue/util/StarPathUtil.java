package yue.util;

import android.graphics.Matrix;
import android.graphics.Path;
import android.support.annotation.FloatRange;
import android.util.Log;

/**
 * Created by Yue on 2017/4/4.
 */

public class StarPathUtil {

        /**
         * 连接路径
         */
        public static Path linePath(double r,int hormCount,@FloatRange(from=0,to =1) float depth){
            Path starPath = new Path();

            double sOrs = Math.PI * (90 - 180.0 / hormCount) / 180;//角arf的弧度
            double sPro = (1.0 - depth) * sOrs;//角pra的弧度
            double sPrs = depth*sOrs;//角prs的弧度

            //圆内接正多边形边长公式2r*sin(180/n);rs = 边长/2
            double lRs = r * Math.sin(Math.PI / hormCount);
            double pr = lRs/Math.cos(sPrs);
            //p点坐标
            double pX = pr * Math.sin(sPro);
            double pY = pr * Math.cos(sPro);

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
            //循环求出每旋转c==PI*(360/hormCount)/180弧度后r点和p点的坐标，并构建为路径
            for (int i = 0;i<hormCount;i++){
                double c = i*2*Math.PI/hormCount;
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
            Matrix m = new Matrix();
            //旋转角度
//            m.setRotate(rotate);
            //计算时坐标系平移(r,0)，现路径整体平移过去，以符合坐标系。
            m.setTranslate((float) r,0);
            starPath.transform(m);

            return starPath;
        }
    }
