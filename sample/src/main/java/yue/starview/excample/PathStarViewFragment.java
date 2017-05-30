package yue.starview.excample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yue.starview.excample.PathStartViewPre.DepthActivity;
import yue.starview.excample.PathStartViewPre.ManyStarActivity;
import yue.starview.excample.PathStartViewPre.RotateActivity;
import yue.starview.excample.PathStartViewPre.StarHormActivity;
import yue.starview.excample.PathStartViewPre.StarSizeActivity;

/**
 * Created by Yue on 2017/4/24.
 */

public class PathStarViewFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.pathstarview_frag,null,false);
//        GridView gridView = (GridView) contentView.findViewById(R.id.gridView_stars);
//        gridView.setAdapter(new GridStarsAdapter(getContext(),100));
        contentView.findViewById(R.id.btn_starHorm).setOnClickListener(this);
        contentView.findViewById(R.id.btn_starSize).setOnClickListener(this);
        contentView.findViewById(R.id.btn_depth).setOnClickListener(this);
        contentView.findViewById(R.id.btn_rotate).setOnClickListener(this);
        contentView.findViewById(R.id.btn_many).setOnClickListener(this);
        return contentView;
    }

    @Override
    public void onClick(View v) {
        Class cls = null;
        switch (v.getId()) {
            case R.id.btn_depth:
                cls = DepthActivity.class;
                break;
            case R.id.btn_many:
                cls = ManyStarActivity.class;
                break;
            case R.id.btn_rotate:
                cls = RotateActivity.class;
                break;
            case R.id.btn_starSize:
                cls = StarSizeActivity.class;
                break;
            case R.id.btn_starHorm:
                cls = StarHormActivity.class;
                break;
            default:
                cls = ManyStarActivity.class;
        		break;
        }
        Intent intent = new Intent(getContext(),cls);
        startActivity(intent);
    }
}
