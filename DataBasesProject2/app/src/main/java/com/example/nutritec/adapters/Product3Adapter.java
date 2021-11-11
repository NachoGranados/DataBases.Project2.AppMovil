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

public class Product3Adapter extends RecyclerView.Adapter<Product3Adapter.Product3ViewHolder> {

    Context context;
    List<Product> productList;

    public Product3Adapter(Context context, List<Product> productList) {

        this.context = context;
        this.productList = productList;

    }

    @NonNull
    @Override
    public Product3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_3, parent, false);

        return new Product3Adapter.Product3ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product3ViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.barcodeTextView.setText("Barcode: " + product.getBarcode());
        holder.nameTextView.setText("Name: " + product.getName());
        holder.descriptionTextView.setText("Description: " + product.getDescription());

    }

    @Override
    public int getItemCount() {

        return productList.size();

    }

    public class Product3ViewHolder extends RecyclerView.ViewHolder {

        TextView barcodeTextView;
        TextView nameTextView;
        TextView descriptionTextView;

        public Product3ViewHolder(@NonNull View itemView) {

            super(itemView);

            barcodeTextView = itemView.findViewById(R.id.textViewProductItem3Barcode);
            nameTextView = itemView.findViewById(R.id.textViewProductItem3Name);
            descriptionTextView = itemView.findViewById(R.id.textViewProductItem3Description);

        }

    }

}
