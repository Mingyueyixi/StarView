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

public class DepthAdapter extends BaseAdapter {
    private final Context context;
    private final float density;
    private float depth;
    private int horm;
    private int size;

    public DepthAdapter(Context context, float depth) {
        this.context = context;
        this.depth = depth;
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
        pathStarView.setStar(horm, ColorUtil.getRadomRGB(),depth,0,0f);
        tv_info.setText("horm:"+horm+" size:"+size+"dp");

        return viewHolder.getConvertView();
    }

    public void setDepth(float depth) {
        Random random = new Random();
        int horm = random.nextInt(30);
        int sizeDp = 20+random.nextInt(80);

        if (this.depth == depth && this.horm == horm && this.size == sizeDp){
            return;
        }
        this.horm = horm;
        this.size = sizeDp;
        this.depth = depth;
        notifyDataSetChanged();
    }
}
