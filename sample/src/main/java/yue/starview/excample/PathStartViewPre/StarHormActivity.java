package yue.starview.excample.PathStartViewPre;

import android.widget.EditText;
import android.widget.TextView;

import yue.starview.excample.PathStartViewPre.adapter.StarHormAdapter;

/**
 * Created by Yue on 2017/5/30.
 */

public class StarHormActivity extends BasePathStarActivity<StarHormAdapter> {


    @Override
    protected void changeView(EditText et_horm, TextView tv_label) {

    }

    @Override
    protected StarHormAdapter initAdapter() {
        return new StarHormAdapter(this,5);
    }

    @Override
    protected void adapterUpdate(StarHormAdapter adapter, String etInputStr) {
        int horm = Integer.parseInt(etInputStr);
        adapter.setHorm(horm);
    }
}