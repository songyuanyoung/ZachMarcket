package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */

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


public class ProductAdapter extends RecyclerView.Adapter<ProductHolder>{
    String ORDER_DELIVER_ADD = "zach", curent_date = "6/25/2017", user_phone = "2193085517";
    private Context mContext;
    private ArrayList<Product> mList;
    ArrayList<OrderItem> myOrders;
    public ProductAdapter(Context context, ArrayList<Product> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ProductHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.product_item_layout, parent, false);
        final ProductHolder holder = new ProductHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ProductHolder holder, final int position) {
        final Product product = mList.get(position);
        holder.mTextId.setText(product.getItemId());

        holder.mTextName.setText(product.getItemName());
        holder.mPrice.setText("Price: " + product.getItemPrice());
        myOrders = OrderList.getInstance();

        Picasso.with(mContext).load(product.getItemThumb()).into(holder.mImageView);

        holder.mDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(holder.mQuantity.getText().toString()) == 0) {
                    Toast.makeText(v.getContext(), "Quantity mush be more than 0", Toast.LENGTH_SHORT).show();
                } else {
                    int q =Integer.parseInt(holder.mQuantity.getText().toString()) - 1;
                    holder.mQuantity.setText(q + "");

                    OrderItem mOrderItem = new OrderItem(product.getGroceryCategoryId(),
                            product.getItemName(),
                            q,
                            product.getItemPrice(),
                            ORDER_DELIVER_ADD,
                            curent_date,
                            user_phone,
                            product.getItemThumb());
                    removeFromChart(mOrderItem);
                }
            }
        });
        holder.mIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q =Integer.parseInt(holder.mQuantity.getText().toString()) + 1;
                holder.mQuantity.setText(q + "");


                OrderItem mOrderItem = new OrderItem(product.getGroceryCategoryId(),
                        product.getItemName(),
                        q,
                        product.getItemPrice(),
                        ORDER_DELIVER_ADD,
                        curent_date,
                        user_phone,
                        product.getItemThumb());
                addToChart(mOrderItem);

            }
        });


    }
    private void addToChart(OrderItem orderItem) {

        if (hasItemInOrderList(orderItem)) {
            int index = findIndex(orderItem);
            OrderItem order = myOrders.get(index);
            Toast.makeText(mContext, index +"", Toast.LENGTH_SHORT).show();
            int oldQuantity = order.getOrder_quantity() + 1;
            order.setOrder_quantity(oldQuantity);
        } else {
            myOrders.add(orderItem);
        }
    }
    private  void removeFromChart(OrderItem orderItem) {
        ArrayList<OrderItem> myOrders = OrderList.getInstance();
        if (hasItemInOrderList(orderItem)) {
            int index = findIndex(orderItem);
            OrderItem order = myOrders.get(index);
            int oldQuantity = order.getOrder_quantity();
            order.setOrder_quantity(oldQuantity - 1);
        }
    }
    private boolean hasItemInOrderList(OrderItem orderItem) {
        ArrayList<OrderItem> temp = OrderList.getInstance();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getOrder_name().toString().equals(orderItem.getOrder_name().toString())) {
                return true;
            }
        }
        return false;
    }
    private int findIndex(OrderItem orderItem) {
        ArrayList<OrderItem> temp = OrderList.getInstance();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getOrder_name() .equals( orderItem.getOrder_name())) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
}



class ProductHolder extends RecyclerView.ViewHolder {
    TextView mTextName, mTextId, mPrice, mQuantity;
    ImageView mImageView;
    Button mIncrease, mDecrease;

    public ProductHolder(View itemView) {
        super(itemView);
        mTextName = (TextView) itemView.findViewById(R.id.item_name);
        mTextId = (TextView) itemView.findViewById(R.id.item_id);
        mPrice = (TextView)itemView.findViewById(R.id.item_price);
        mImageView = (ImageView) itemView.findViewById(R.id.item_image);
        mQuantity = (TextView) itemView.findViewById(R.id.quantity);
        mIncrease = (Button) itemView.findViewById(R.id.increaseQuantaty);
        mDecrease = (Button) itemView.findViewById(R.id.decreaseQuantity);

    }
}

