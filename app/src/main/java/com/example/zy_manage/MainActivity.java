package com.example.zy_manage;
import androidx.fragment.app.Fragment;

import com.example.zy_manage.Activity.BaseActivity;
import com.example.zy_manage.Adapter.MyPagerAdapter;
import com.example.zy_manage.Entity.TabEntity;
import com.example.zy_manage.Fragment.HomeFragment;
import com.example.zy_manage.Fragment.MyFragment;
import com.example.zy_manage.Fragment.WorkFragment;
import com.example.zy_manage.View.FixedViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private String[] mTitles = {"首页", "事务", "我的"};
    private int[] mIconUnselectIds = {
            R.drawable.home_unselect, R.drawable.work_unselect,
            R.drawable.my_unselect};
    private int[] mIconSelectIds = {
            R.drawable.home_select, R.drawable.work_select,
            R.drawable.my_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout commonTabLayout;
    private FixedViewPager viewPager;
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpage);
        commonTabLayout = findViewById(R.id.commonTabLayout);


    }

    @Override
    protected void initData() {
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(WorkFragment.newInstance());
        mFragments.add(MyFragment.newInstance());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.setCanSwipe(false);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
    }
}