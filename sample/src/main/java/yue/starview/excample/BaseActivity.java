package yue.starview.excample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yue on 2017/3/27.
 */

public class BaseActivity extends AppCompatActivity{
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cleanFragmentList();
    }
    public int getFragmentListSize(){
        return fragmentList.size();
    }
    protected void addFragment(Fragment ...fragment){
        for (Fragment frag : fragment) {
            fragmentList.add(frag);
        }
    }
    protected void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
    protected Fragment getFragment(int position){
        if(!checkFragmentIndex(position)){
            return null;
        }
        return fragmentList.get(position);
    }
    protected void addFragments(List<Fragment> fragments){
        fragmentList.addAll(fragments);
    }
    protected void removeFragment(int position){
        if (checkFragmentIndex(position)){
            fragmentList.remove(position);
        }
    }
    private boolean checkFragmentIndex(int position){
        if (position<fragmentList.size() & position>=0){
            return true;
        }
        return false;
    }
    protected  void cleanFragmentList(){
        fragmentList.clear();
        fragmentList = null;
    }
}
