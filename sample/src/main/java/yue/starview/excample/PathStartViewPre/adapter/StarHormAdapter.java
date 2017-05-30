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
 * Created by Yue on 2017/5/30.
 */

public class StarHormAdapter extends BaseAdapter {
    private final Context context;
    private final float density;
    private int horm = 5;
    private float depth;

    public StarHormAdapter(Context context, int horm) {
        this.context = context;
        this.horm = horm;
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

        int sizeDp = 10*(position+1);
        int size = (int) (sizeDp*density);
        pathStarView.setWidth(size);
        pathStarView.setHeight(size);
        pathStarView.setStar(horm, ColorUtil.getRadomRGB(),depth,0,0);

        tv_info.setText("大小:"+sizeDp+"dp"+"  depth:"+depth);

        return viewHolder.getConvertView();
    }

    public void setHorm(int horm) {
        this.horm = horm;
        depth = (float)Math.random();
//        Log.e("测试",this.horm+"");
//        notifyDaSetInvalidated();//视图树全部重新排列并刷新。会回到第一个item页面
        notifyDataSetChanged();//根据数据刷新。
    }
}
