package yue.starview.excample.util;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Yue on 2017/5/30.
 */

public class ColorUtil {
    public static int getRadomRGB(){
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return Color.rgb(red,green,blue);
    }
}
