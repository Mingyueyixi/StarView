package yue.starview.excample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.view.View.*;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        addFragment(new StarViewFragment(),new StarDrawableFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return getFragment(position);
            }
            @Override
            public int getCount() {
                return getFragmentListSize();
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

}


}
