package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;



public class OrdersAdapter extends RecyclerView.Adapter<OrdersHolder>{
    String ORDER_DELIVER_ADD = "zach", curent_date = "6/25/2017", user_phone = "2193085517";
    private Context mContext;
    private ArrayList<OrderItem> mList;

    public OrdersAdapter(Context context, ArrayList<OrderItem> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public OrdersHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.order_item_layout, parent, false);
        final OrdersHolder holder = new OrdersHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final OrdersHolder holder, final int position) {
        final OrderItem orderItem = mList.get(position);


        holder.mTextName.setText("Name:" + orderItem.getOrder_name());
        holder.mPrice.setText("Price: " + orderItem.getOrder_price());
        holder.mQuantity.setText("Quantity:" + orderItem.getOrder_quantity());

        Picasso.with(mContext).load(orderItem.getOrder_thumb()).into(holder.mImageView);


    }
    private String getOrderImage(OrderItem orderItem) {
        String orderName = orderItem.getOrder_name();
        ArrayList<Product> products = ProductList.getInstance();
        for (int i = 0; i < products.size(); i++) {
            if (orderItem.equals(products.get(i).getItemName())) {
                return products.get(i).getItemThumb();
            }
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}



class OrdersHolder extends RecyclerView.ViewHolder {
    TextView mTextName, mPrice, mQuantity;
    ImageView mImageView;

    public OrdersHolder(View itemView) {
        super(itemView);
        mTextName = (TextView) itemView.findViewById(R.id.order_name);
        mPrice = (TextView)itemView.findViewById(R.id.order_price);
        mImageView = (ImageView) itemView.findViewById(R.id.order_image);
        mQuantity = (TextView) itemView.findViewById(R.id.order_quantity);
    }
}

