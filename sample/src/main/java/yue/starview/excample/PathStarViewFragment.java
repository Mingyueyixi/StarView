package yue.starview.excample;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import yue.starview.PathStarView;

import static android.R.attr.max;
import static android.graphics.Color.argb;

/**
 * Created by Yue on 2017/4/24.
 */

public class PathStarViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.pathstarview_frag,null,false);
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter();
        return contentView;
    }
    private List<PathStarView> starViews;
    private void initStarViews(int count){
        if (starViews == null){
            starViews = new ArrayList<>();
        }else return;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            PathStarView pathStarView = new PathStarView(this);
            float f = 255f/count;
            int red = Color.red((int) (i*f));
            int green = Color.green((int) ((count-i)*f));
            int blue = Color.blue(0x666666);
            int color = Color.argb(1,red,green,blue);
            int rotate = i*360/count;

            float depth = (float) ((Math.random()*(90-30)+90)/100f);
            pathStarView.setStar(i+3,color,depth,0,rotate);
            starViews.add(pathStarView);
        }
    }
    private class StarRecyclerAdapter extends RecyclerView.Adapter{
        private static class ViewHolder{

        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            if (starViews == null){
                starViews = new ArrayList<>();
            }
            return starViews.size();
        }
    }
}
