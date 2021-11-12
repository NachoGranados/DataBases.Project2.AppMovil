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
import com.example.nutritec.models.Product1;

import java.util.List;

public class Product1Adapter extends RecyclerView.Adapter<Product1Adapter.Product1ViewHolder> {

    Context context;
    List<Product1> product1List;

    public Product1Adapter(Context context, List<Product1> product1List) {

        this.context = context;
        this.product1List = product1List;

    }

    @NonNull
    @Override
    public Product1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_1, parent, false);

        return new Product1Adapter.Product1ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product1ViewHolder holder, int position) {

        Product1 product1 = product1List.get(position);

        holder.barcodeTextView.setText("Barcode: " + product1.getNumber());
        holder.nameTextView.setText("Name: " + product1.getName());

    }

    @Override
    public int getItemCount() {

        return product1List.size();

    }

    public class Product1ViewHolder extends RecyclerView.ViewHolder {

        TextView barcodeTextView;
        TextView nameTextView;

        public Product1ViewHolder(@NonNull View itemView) {

            super(itemView);

            barcodeTextView = itemView.findViewById(R.id.textViewProductItem1Barcode);
            nameTextView = itemView.findViewById(R.id.textViewProductItem1Name);

        }

    }

}
