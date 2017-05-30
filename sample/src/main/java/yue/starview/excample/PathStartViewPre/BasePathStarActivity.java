package yue.starview.excample.PathStartViewPre;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import yue.starview.excample.BaseActivity;
import yue.starview.excample.PathStartViewPre.adapter.StarHormAdapter;
import yue.starview.excample.R;

/**
 * Created by Yue on 2017/5/30.
 */

public abstract class BasePathStarActivity<T extends ListAdapter> extends BaseActivity implements View.OnClickListener{

    private EditText et_horm;
    private StarHormAdapter adapter;
    private ListView listView;
    private SparseArray<View> viewList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_star_size_depth_rotate);
        listView = (ListView) findViewById(R.id.lv_starsize);
        et_horm = (EditText)findViewById(R.id.et_horm_starsize);
        findViewById(R.id.btn_ok_starsize).setOnClickListener(this);
        TextView tv_label = (TextView) findViewById(R.id.tv_label);


        changeView(et_horm,tv_label);
        setRootAdapter();

    }

    protected abstract void changeView(EditText et_horm, TextView tv_label);

    protected void setRootAdapter(){
        listView.setAdapter(initAdapter());
    }

    protected abstract T initAdapter();
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ok_starsize){
            String contentStr = et_horm.getText().toString().trim();
            if (TextUtils.isEmpty(contentStr)){
                return ;
            }
            adapterUpdate((T) listView.getAdapter(),contentStr);
        }
    }

    protected abstract void adapterUpdate(T adapter , String etInputStr);


}
