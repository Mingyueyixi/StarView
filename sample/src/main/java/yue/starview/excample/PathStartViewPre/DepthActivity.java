package yue.starview.excample.PathStartViewPre;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import yue.starview.excample.PathStartViewPre.adapter.DepthAdapter;

/**
 * Created by Yue on 2017/5/29.
 */

public class DepthActivity extends BasePathStarActivity<DepthAdapter>{

    @Override
    protected void changeView(EditText et_horm, TextView tv_label) {
        tv_label.setText("depth（0~1）：");
        et_horm.setText("");
    }

    @Override
    protected DepthAdapter initAdapter() {
        return new DepthAdapter(this,0);
    }

    @Override
    protected void adapterUpdate(DepthAdapter adapter, String etInputStr) {
        float depth = Float.parseFloat(etInputStr);
        if (depth>1||depth<0){
            Toast.makeText(this,"depth超出取值范围：0~1",Toast.LENGTH_SHORT).show();
            return;
        }
        adapter.setDepth(depth);

    }
}
