package com.example.nutritec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.models.Product;

import java.util.List;

public class Product2Adapter extends RecyclerView.Adapter<Product2Adapter.Product2ViewHolder> {

    Context context;
    List<Product> productList;

    public Product2Adapter(Context context, List<Product> productList) {

        this.context = context;
        this.productList = productList;

    }

    @NonNull
    @Override
    public Product2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_2, parent, false);

        return new Product2Adapter.Product2ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product2ViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.barcode.setText("Barcode: " + product.getBarcode());
        holder.name.setText("Name: " + product.getName());
        holder.description.setText("Description: " + product.getDescription());

        holder.addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                // REST API PR.9 METHOD






            }
        });

    }

    @Override
    public int getItemCount() {

        return productList.size();

    }

    public class Product2ViewHolder extends RecyclerView.ViewHolder {

        TextView barcode;
        TextView name;
        TextView description;

        Button addProduct;

        public Product2ViewHolder(@NonNull View itemView) {

            super(itemView);

            barcode = itemView.findViewById(R.id.textViewProductItem2Barcode);
            name = itemView.findViewById(R.id.textViewProductItem2Name);
            description = itemView.findViewById(R.id.textViewProductItem2Description);

            addProduct = itemView.findViewById(R.id.buttonProductItem2AddProduct);

        }

    }

}
