package com.example.nutritec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.models.Product;

import java.util.List;

public class Product1Adapter extends RecyclerView.Adapter<Product1Adapter.Product1ViewHolder> {

    Context context;
    List<Product> productList;

    public Product1Adapter(Context context, List<Product> productList) {

        this.context = context;
        this.productList = productList;

    }

    @NonNull
    @Override
    public Product1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_1, parent, false);

        return new Product1Adapter.Product1ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product1ViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.barcode.setText("Barcode: " + product.getBarcode());
        holder.name.setText("Name: " + product.getName());

    }

    @Override
    public int getItemCount() {

        return productList.size();

    }

    public class Product1ViewHolder extends RecyclerView.ViewHolder {

        TextView barcode;
        TextView name;

        public Product1ViewHolder(@NonNull View itemView) {

            super(itemView);

            barcode = itemView.findViewById(R.id.textViewProductItem1Barcode);
            name = itemView.findViewById(R.id.textViewProductItem1Name);

        }

    }

}
