package com.example.zhangwenpurdue.zachmarcket;

/**
 * Created by zhangwenpurdue on 6/25/2017.
 */
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategorytHolder>{

    private Context mContext;
    private ArrayList<SubCategory> mList;

    public SubCategoryAdapter(Context context, ArrayList<SubCategory> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public SubCategorytHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.category_item_layout, parent, false);
        final SubCategorytHolder holder = new SubCategorytHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SubCategorytHolder holder, final int position) {
        final SubCategory subCategory = mList.get(position);
        holder.mTextName.setText(subCategory.getGrocerySubCategoryName());
        holder.mTextId.setText(subCategory.getGrocerySubCategoryId());
        Picasso.with(mContext).load(subCategory.getGroceryThumb()).into(holder.mImageView);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frag_Product frag_product = Frag_Product.newInstance("category_id=" + subCategory.getGroceryCategoryId() + "&sub_category_id=" + subCategory.getGrocerySubCategoryId());
                ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, frag_product).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}


class SubCategorytHolder extends RecyclerView.ViewHolder {
    TextView mTextName, mTextId;
    ImageView mImageView;

    public SubCategorytHolder(View itemView) {
        super(itemView);
        mTextName = (TextView) itemView.findViewById(R.id.category_name);
        mTextId = (TextView) itemView.findViewById(R.id.category_id);
        mImageView = (ImageView) itemView.findViewById(R.id.category_image);

    }
}

