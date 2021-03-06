package com.example.wdong.myapplication;

//import android.app.FragmentManager;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.List;

/**
 * Created by wdong on 2015/9/16.
 */
public class TabPagerAdapter extends MyFragmentAdapter {

    private List<Fragment> list;

    public TabPagerAdapter(FragmentManager fm, List<Fragment> list){
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
