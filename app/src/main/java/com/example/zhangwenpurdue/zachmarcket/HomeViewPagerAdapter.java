package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter{
    private String[] titles;
    private ArrayList<Frag_Category> viewPagerFragments;

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void setTitles(String[] titles) {
        this.titles = titles;
    }
    public void setFragments(ArrayList<Frag_Category> fragments) {
        viewPagerFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return viewPagerFragments.get(position);
    }

    @Override
    public int getCount() {
        return viewPagerFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}

