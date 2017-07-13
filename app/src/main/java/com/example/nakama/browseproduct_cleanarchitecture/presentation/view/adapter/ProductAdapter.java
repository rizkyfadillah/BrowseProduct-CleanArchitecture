package com.example.nakama.browseproduct_cleanarchitecture.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;
import com.example.nakama.browseproduct_cleanarchitecture.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nakama on 12/07/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<ProductModel> productModelList;
    private Context context;

    public ProductAdapter(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context)
                .load(productModelList.get(position).getImage_url())
                .into(holder.imageView);
        holder.tvProductName.setText(productModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvProductName;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            tvProductName = (TextView) itemView.findViewById(R.id.tv_product_name);
        }

    }

}
