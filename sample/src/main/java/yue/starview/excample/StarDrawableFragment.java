package yue.starview.excample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import yue.drawable.StarDrawable;
import yue.starview.excample.util.ColorUtil;

/**
 * Created by Yue on 2017/3/29.
 */

public class StarDrawableFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = (ViewGroup) inflater.inflate(R.layout.stardrawable_frag,null,false);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.layout_drawable);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        StarDrawable starDrawable = new StarDrawable(Color.BLUE,200,0,3,0.7f);
        imageView.setBackgroundDrawable(starDrawable);


        for (int i=4;i<16;i++){
            ImageView image = new ImageView(getContext());
            StarDrawable bg = new StarDrawable(ColorUtil.getRadomRGB(),100,0,i,0.6f);
            image.setBackgroundDrawable(bg);
            linearLayout.addView(image);
        }

        return rootView;
    }
}
