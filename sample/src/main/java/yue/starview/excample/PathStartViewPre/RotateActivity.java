package yue.starview.excample.PathStartViewPre;

import android.widget.EditText;
import android.widget.TextView;

import yue.starview.excample.PathStartViewPre.adapter.RotateAdapter;

/**
 * Created by Yue on 2017/5/29.
 */

public class RotateActivity extends BasePathStarActivity<RotateAdapter> {

    @Override
    protected void changeView(EditText et_horm, TextView tv_label) {
        tv_label.setText("旋转角度：");
        et_horm.setText("0");
    }

    @Override
    protected RotateAdapter initAdapter() {
        return new RotateAdapter(this,0);
    }

    @Override
    protected void adapterUpdate(RotateAdapter adapter, String etInputStr) {
        float rotate = Float.parseFloat(etInputStr);
        adapter.setRotate(rotate);
    }
}
