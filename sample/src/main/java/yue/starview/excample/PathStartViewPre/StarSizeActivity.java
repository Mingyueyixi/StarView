package yue.starview.excample.PathStartViewPre;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import yue.starview.excample.PathStartViewPre.adapter.StarSizeAdapter;

/**
 * Created by Yue on 2017/5/29.
 */

public class StarSizeActivity extends BasePathStarActivity<StarSizeAdapter>{


    @Override
    protected void changeView(EditText et_horm, TextView tv_label) {
        tv_label.setText("大小（dp）：");
    }

    @Override
    protected StarSizeAdapter initAdapter() {
        return new StarSizeAdapter(this,5);
    }

    @Override
    protected void adapterUpdate(StarSizeAdapter adapter, String etInputStr) {
        int size = Integer.parseInt(etInputStr);
        if (size<0||size>300){
            Toast.makeText(this,"尺寸超出0~150dp范围",Toast.LENGTH_SHORT).show();
        }
        adapter.setSize(size);
    }
}
