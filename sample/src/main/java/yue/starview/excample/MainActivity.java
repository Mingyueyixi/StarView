package yue.starview.excample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import yue.starview.OnStarClickListener;
import yue.starview.StarsView;

public class MainActivity extends BaseActivity implements OnStarClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = getLayoutInflater().inflate(R.layout.activity_main,null,false);
        setContentView(contentView);

        listenAllStarView(contentView);

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
