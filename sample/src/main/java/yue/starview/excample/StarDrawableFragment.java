package yue.starview.excample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import yue.drawable.StarDrawable;

/**
 * Created by Yue on 2017/3/29.
 */

public class StarDrawableFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stardrawable_frag,null,false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        StarDrawable starDrawable = new StarDrawable(Color.BLUE,200,0,8,0.7f);
        imageView.setBackgroundDrawable(starDrawable);
        return rootView;
    }
}
