package yue.starview.excample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yue.starview.OnStarClickListener;
import yue.starview.StarsView;

/**
 * Created by Yue on 2017/3/29.
 */

public class StarViewFragment extends Fragment implements OnStarClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.starview_frag,null,false);
        listenAllStarView(contentView);
        return contentView;
    }
    /**
     * @param root
     * 监听所有StarView
     */
    private void listenAllStarView(View root) {
        if (root instanceof ViewGroup) {//Android的布局继承自ViewGroup
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                listenAllStarView(parent.getChildAt(i));
            }
        }else if (root instanceof StarsView){
            ((StarsView)root).setOnStarClickListener(this);
            Log.w("测试",">");
        }
    }

    @Override
    public void onClick(View view, int position) {
        int flag = position+1;
        Log.w("测试",flag+"");
        Snackbar.make(view,"第"+flag+"颗星星",Snackbar.LENGTH_INDEFINITE).show();

    }
}
