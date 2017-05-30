package yue.starview.excample.PathStartViewPre.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import yue.starview.PathStarView;
import yue.starview.excample.R;
import yue.starview.excample.util.ColorUtil;
import yue.starview.excample.util.ViewHolder;

/**
 * Created by Yue on 2017/5/29.
 */

public class GridStarsAdapter extends BaseAdapter {
    private final Context context;
    private int count;
    private float density;

    public GridStarsAdapter(Context context,int count) {
        density = context.getResources().getDisplayMetrics().density;
        this.context = context;
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
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
        TextView textView = viewHolder.getView(R.id.tv_starview_info);

        int size = (int) ((40+position)*density);
        if (position%2!=0){
            size = (int) ((39+position)*density);
        }
        float depth = 0.4f+(0.6f*position/count);
        int rotate = (int) (360f*position/count);

        pathStarView.setWidth(size);
        pathStarView.setHeight(size);

        pathStarView.setStar(position+3, ColorUtil.getRadomRGB(),depth,0,rotate);

        textView.setText("大小："+size+"depth:"+depth+"rotate："+rotate);
//        Log.e("测试：","长："+size+"宽："+size+"depth:"+depth+"rotate："+rotate);
        return viewHolder.getConvertView();
    }
}
