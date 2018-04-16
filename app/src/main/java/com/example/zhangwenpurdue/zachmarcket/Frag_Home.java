package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Frag_Home extends Fragment {
    private static final String KEY = "extra";
    private final String BASE_URL = "http://rjtmobile.com/aamir/grocery/MobileApp/grocery_list.php?";
    public static ArrayList<Category> mList = CategoryList.getInstance();
    TabLayout tabLayout;
    ViewPager viewPager;
    HomeViewPagerAdapter homeViewPagerAdapter;
    private ArrayList<String> mTitles;
    ArrayList<Frag_Category> mViewPagerFragments;
    Frag_Category one, two, three;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home_layout, container, false);
        mTitles = new ArrayList<>();

        tabLayout = (TabLayout) view.findViewById(R.id.home_tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);

        fetchData();
        //


        return view;
    }
    public static Frag_Home newInstance(String extra) {
        Bundle args = new Bundle();
        args.putString(KEY, extra);
        Frag_Home fragment = new Frag_Home();
        fragment.setArguments(args);
        return fragment;
    }

    private void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray categories = new JSONObject(response).getJSONArray("Grocery Category");
                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        Category category = new Category();
                        if (item.has("GroceryId")) {
                            String gId = item.getString("GroceryId");
                            category.setmGroceryId(gId);
                        }
                        if (item.has("GroceryName")) {
                            String gName = item.getString("GroceryName");
                            category.setmGroceryName(gName);

                        }
                        if (item.has("GroceryThumb")) {
                            String image = item.getString("GroceryThumb");
                            category.setmGroceryThumb(image);
                        }

                        mList.add(category);

                    }
                    String[] temp = new String[mList.size()];
                    for (int i = 0; i < mList.size(); i++) {
                        temp[i] = mList.get(i).getmGroceryName();
                    }
                    mViewPagerFragments = new ArrayList<Frag_Category>();
                    homeViewPagerAdapter = new HomeViewPagerAdapter(getActivity().getSupportFragmentManager());
                    for (int i = 0; i < mList.size(); i++) {
                        mViewPagerFragments.add(Frag_Category.newInstance(mList.get(i).getmGroceryId()));
                    }
                    homeViewPagerAdapter.setTitles(temp);
                    // homeViewPagerAdapter.setTitles(mTitles.toArray());
                    homeViewPagerAdapter.setFragments(mViewPagerFragments);


                    viewPager.setAdapter(homeViewPagerAdapter);
                    tabLayout.setupWithViewPager(viewPager);

                    // mRecyclerView.setAdapter(new ProductAdapter(getActivity(), mList));
                    //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("test", "exception");
            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest, "hshs");

    }


}



