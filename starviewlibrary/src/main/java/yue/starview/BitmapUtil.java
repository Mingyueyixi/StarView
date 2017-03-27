package yue.starview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class BitmapUtil {

	private static final String TAG = BitmapUtil.class.getSimpleName();

	public static Bitmap drawableToBitmap(Drawable drawable) {
		return drawableToBitmap(drawable,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
	}
	public static Bitmap drawableToBitmap(Drawable drawable,int width,int height) {
		if (drawable==null) {
			Log.w(TAG, "drawable is null");
			return null;
		}
		Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;
	}

	public static Bitmap createColorBitmap(int width,int height,int color){
		return createColorBitmap(width, height, color, Config.ARGB_8888);
	}
	public static Bitmap createColorBitmap(int width,int height,int color,Config config){
		Bitmap bitmap = Bitmap.createBitmap(width, height, config);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawColor(color);
		return bitmap;
	}

}

