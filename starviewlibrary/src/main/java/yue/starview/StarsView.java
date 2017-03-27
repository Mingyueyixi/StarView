package yue.starview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.icu.lang.UCharacter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class StarsView extends View{

    private static final int DEFAULT_SIZE = 40;
    private static final int DEFAULT_COUNT = 5;

    /** star资源id */
    private int starResId;
    /** star总数 */
    private int starCount;
    private int starSize;
    private Bitmap starBitmap;
    private Drawable starDrawable;
    private Paint paint;

    private OnStarClickListener mOnStarClickListener;
    /**
     * @param onStarClickListener star监听器
     **/
    public void setOnStarClickListener(OnStarClickListener onStarClickListener){
        mOnStarClickListener = onStarClickListener;
    }

    public StarsView(Context context) {
        this(context,null);
    }

    public StarsView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public StarsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Resources res = context.getResources();
        TypedArray a = res.obtainAttributes(attrs, R.styleable.StarsView);
        starResId = a.getResourceId(R.styleable.StarsView_starSrc, R.drawable.ic_star_yellow);
        starCount = a.getInt(R.styleable.StarsView_starCount,DEFAULT_COUNT);
        starSize = a.getDimensionPixelSize(R.styleable.StarsView_starSize, DEFAULT_SIZE);
        a.recycle();

        starDrawable = res.getDrawable(starResId);
        if (starSize == 0) {
            starSize = starDrawable.getIntrinsicWidth();
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
    public int getStarCount() {
        return starCount;
    }
    public int getStarResId() {
        return starResId;
    }
    public void setStarCount(int starCount) {
        this.starCount = starCount;
        update();
    }
    private void update(){
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        float top = (height-starSize)/2.0f;

        for (int i = 0; i < starCount; i++) {
            int left = i*starSize;
            if (starBitmap!=null) {
                canvas.drawBitmap(starBitmap, left, top, paint);
            }
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);

        if (wMode == MeasureSpec.AT_MOST) {//尽可能大，对应wrap_content
            width = (int) (starCount*(double)starSize);
        }else if (wMode == MeasureSpec.EXACTLY) {
            starSize = (int) (width/(double)starCount);
        }else {
            width = getScreenWidth(getContext());
        }
        if (hMode == MeasureSpec.AT_MOST) {
            height = starSize;
        }else if (wMode == MeasureSpec.EXACTLY) {
            starSize = (int) (width/(double)starCount);
        }else {
            height = getScreenHeight(getContext());
        }
        setMeasuredDimension(width, height);
        starBitmap = BitmapUtil.drawableToBitmap(starDrawable, starSize, starSize);

    }

    /**
     * @param context
     * @return 屏幕高度
     */
    public static int getScreenHeight(Context context){
        DisplayMetrics outMetrics = getScreenSize(context);
        return outMetrics.widthPixels;
    }
    /**
     * @param context
     * @return 屏幕宽度
     */
    public static int getScreenWidth(Context context){
        DisplayMetrics outMetrics = getScreenSize(context);
        return outMetrics.widthPixels;

    }
    /**
     * @param context
     * @return 屏幕宽高的DisplayMetrics
     */
    public static DisplayMetrics getScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (mOnStarClickListener != null) {
            final float x = event.getX();
            final float y = event.getY();
            final int action = event.getAction();

            if (action==MotionEvent.ACTION_UP) {
                final int position = (int) (x / (getWidth() / starCount));
                mOnStarClickListener.onClick(this, position);
                return true;
            }
        }else {//当不设置star监听的时候，事件的传递/消耗取决于父方法的判断。
            return super.onTouchEvent(event);
        }

        return true;
    }


}

