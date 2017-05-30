package yue.starview.excample.PathStartViewPre.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Random;

import yue.starview.PathStarView;
import yue.starview.excample.R;
import yue.starview.excample.util.ColorUtil;
import yue.starview.excample.util.ViewHolder;

/**
 * Created by Yue on 2017/5/30.
 */

public class RotateAdapter extends BaseAdapter {
    private final Context context;
    private final float density;
    private float depth;
    private int horm = 5;
    private int size = 40;
    private float rotate;

    public RotateAdapter(Context context, float rotate) {
        this.context = context;
        this.rotate = rotate;
        density = context.getResources().getDisplayMetrics().density;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getHolder(context,convertView,parent, R.layout.item_star_layout,position);
        PathStarView pathStarView = viewHolder.getView(R.id.pathStarView_itself);
        TextView tv_info = viewHolder.getView(R.id.tv_starview_info);

        int sizePix = (int) (size*density);
        pathStarView.setWidth(sizePix);
        pathStarView.setHeight(sizePix);
        pathStarView.setStar(horm, ColorUtil.getRadomRGB(),depth,0,rotate);
        tv_info.setText( "size:"+size+"dp"+"  depth"+depth);

        return viewHolder.getConvertView();
    }

    public void setRotate(float rotate) {
        Random random = new Random();
//        int horm = 3+random.nextInt(12);
        int sizeDp = 20+random.nextInt(80);
        float depth = (float) random.nextDouble();

        if (this.depth == rotate && this.horm == horm && this.size == sizeDp && this.depth == depth){
            return;
        }
//        this.horm = horm;
        this.size = sizeDp;
        this.rotate = rotate;
        this.depth = depth;
        notifyDataSetChanged();
    }
}
