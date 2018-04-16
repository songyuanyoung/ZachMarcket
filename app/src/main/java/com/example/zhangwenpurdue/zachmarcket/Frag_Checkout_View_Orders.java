package com.example.zhangwenpurdue.zachmarcket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

public class Frag_Checkout_View_Orders extends Fragment {
    private ArrayList<OrderItem> myorders = OrderList.getInstance();
    private RecyclerView mRecyclerView;
    private static final String KEY = "extra";
    Button checkOutNow;
    TextView totalAmout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_view_orders_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.orders_recycler);
        mRecyclerView.setAdapter(new OrdersAdapter(getActivity(), myorders));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        checkOutNow = (Button) view.findViewById(R.id.chechOutNow);
        totalAmout = (TextView) view.findViewById(R.id.totalAmount);
        totalAmout.setText(calculateTotal());
        checkOutNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frag_Checkout_Add_address frag_checkout_add_address = Frag_Checkout_Add_address.newInstance(totalAmout.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.activity_check_out, frag_checkout_add_address).commit();
            }
        });
        return view;
    }
    private String calculateTotal() {
        int result = 0;
        for (int i = 0; i < myorders.size(); i++) {
            int price = Integer.parseInt(myorders.get(i).getOrder_price().toString());
            int quantity = myorders.get(i).getOrder_quantity();
            result += (price * quantity);
        }

        return result + "";
    }
    public static Frag_Checkout_View_Orders newInstance(String extra) {
        Bundle args = new Bundle();
        args.putString(KEY, extra);
        Frag_Checkout_View_Orders fragment = new Frag_Checkout_View_Orders();
        fragment.setArguments(args);
        return fragment;
    }
}

