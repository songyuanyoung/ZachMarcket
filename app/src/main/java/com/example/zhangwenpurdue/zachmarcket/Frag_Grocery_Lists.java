package com.example.zhangwenpurdue.zachmarcket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

/**
 * Created by zhangwenpurdue on 6/19/2017.
 */

public class Frag_Grocery_Lists extends Fragment{

    private View viewContent;
    private TabLayout tab_essence;
    private ViewPager vp_essence;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_home_layout,container,false);
        initConentView(viewContent);
        initData();

        return viewContent;
    }

    public void initConentView(View viewContent) {
        this.tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    public void initData() {
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.home_video_tab);

        //创建一个viewpager的adapter
        Grocery_frag_Pager_Adapter adapter = new Grocery_frag_Pager_Adapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);

        //将TabLayout和ViewPager关联起来
        this.tab_essence.setupWithViewPager(this.vp_essence);
    }
}
