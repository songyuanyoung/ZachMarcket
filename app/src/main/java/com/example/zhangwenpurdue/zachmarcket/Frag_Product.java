package com.example.zhangwenpurdue.zachmarcket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class Frag_Product extends Fragment {
    private static final String KEY = "extra";
    private  String BASE_URL = "http://rjtmobile.com/aamir/grocery/MobileApp/grocery_items.php?&";
    public static ArrayList<Product> mList = ProductList.getInstance();
    private RecyclerView mRecyclerView;
    Button checkOut;
    String mMessage = "";
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
        View view = inflater.inflate(R.layout.frag_product_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.product_recycler);
        BASE_URL += mMessage;
        fetchData();
        //Toast.makeText(getActivity(), BASE_URL, Toast.LENGTH_SHORT).show();
        checkOut = (Button) view.findViewById(R.id.checkout);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CheckOut.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
    public static Frag_Product newInstance(String extra) {
        Bundle args = new Bundle();
        args.putString(KEY, extra);
        Frag_Product fragment = new Frag_Product();
        fragment.setArguments(args);
        return fragment;
    }

    private void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray products = new JSONObject(response).getJSONArray("Grocery Items");

                    for (int i = 0; i < products.length(); i++) {
                        JSONObject item = products.getJSONObject(i);
                        Product product = new Product();
                        if (item.has("GroceryCategoryId")) {
                            String gId = item.getString("GroceryCategoryId");
                            product.setGroceryCategoryId(gId);

                        }
                        if (item.has("GrocerySubCategoryId")) {
                            String gsId = item.getString("GrocerySubCategoryId");
                            product.setGrocerySubCategoryId(gsId);

                        }
                        if (item.has("ItemId")) {
                            String gsId = item.getString("ItemId");
                            product.setItemId(gsId);
                        }
                        if (item.has("ItemName")) {
                            String name = item.getString("ItemName");
                            product.setItemName(name);
                        }
                        if (item.has("ItemPrice")) {
                            String price = item.getString("ItemPrice");
                            product.setItemPrice(price);
                        }
                        if (item.has("ItemThumb")) {
                            String image = item.getString("ItemThumb");
                            product.setItemThumb(image);
                        }

                        mList.add(product);

                    }



                    mRecyclerView.setAdapter(new ProductAdapter(getActivity(), mList));
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



