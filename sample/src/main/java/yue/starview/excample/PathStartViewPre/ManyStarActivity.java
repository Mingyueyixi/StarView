package yue.starview.excample.PathStartViewPre;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;

import yue.starview.excample.BaseActivity;
import yue.starview.excample.PathStartViewPre.adapter.GridStarsAdapter;
import yue.starview.excample.R;

/**
 * Created by Yue on 2017/5/29.
 * 这个示例似乎存在bug：部分star颜色未能完成变换
 */

public class ManyStarActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manystar);
        GridView gridView = (GridView)findViewById(R.id.gridView_many);
        gridView.setAdapter(new GridStarsAdapter(this,100));
    }
}
