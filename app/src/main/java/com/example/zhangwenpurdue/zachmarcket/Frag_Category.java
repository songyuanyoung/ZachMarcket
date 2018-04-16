package com.example.zhangwenpurdue.zachmarcket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class Frag_Category extends Fragment {
    private  String BASE_URL = "http://rjtmobile.com/aamir/grocery/MobileApp/grocery_cate.php?&grocery_id=";
    public static ArrayList<SubCategory> mList = SubCategoryList.getInstance();
    private RecyclerView mRecyclerView;



    private static final String KEY = "extra";
    String mMessage = "";
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!= null) {
            mMessage = bundle.getString(KEY);
        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_category_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        BASE_URL += mMessage;
        fetchData();

        return view;
    }
    public static Frag_Category newInstance(String extra) {
        Bundle args = new Bundle();
        args.putString(KEY, extra);
        Frag_Category fragment = new Frag_Category();
        fragment.setArguments(args);
        return fragment;
    }
    private void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray categories = new JSONObject(response).getJSONArray("Grocery Sub Category");

                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        SubCategory subCategory = new SubCategory();
                        if (item.has("GrocerySubCategoryId")) {
                            String gsId = item.getString("GrocerySubCategoryId");
                            subCategory.setGrocerySubCategoryId(gsId);

                        }
                        if (item.has("GroceryCategoryId")) {
                            String gId = item.getString("GroceryCategoryId");
                            subCategory.setGroceryCategoryId(gId);

                        }
                        if (item.has("GrocerySubCategoryName")) {
                            String gsName = item.getString("GrocerySubCategoryName");
                            subCategory.setGrocerySubCategoryName(gsName);
                        }
                        if (item.has("GroceryThumb")) {
                            String image = item.getString("GroceryThumb");
                            subCategory.setGroceryThumb(image);
                        }

                        mList.add(subCategory);

                    }



                    mRecyclerView.setAdapter(new SubCategoryAdapter(getActivity(), mList));
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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

