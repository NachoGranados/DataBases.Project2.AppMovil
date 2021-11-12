package com.example.nutritec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.models.Product2;

import java.util.List;

public class Product3Adapter extends RecyclerView.Adapter<Product3Adapter.Product3ViewHolder> {

    Context context;
    List<Product2> product2List;

    public Product3Adapter(Context context, List<Product2> product2List) {

        this.context = context;
        this.product2List = product2List;

    }

    @NonNull
    @Override
    public Product3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_3, parent, false);

        return new Product3Adapter.Product3ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product3ViewHolder holder, int position) {

        Product2 product2 = product2List.get(position);

        holder.barcodeTextView.setText("Barcode: " + product2.getBarcode());
        holder.nameTextView.setText("Name: " + product2.getName());
        holder.descriptionTextView.setText("Description: " + product2.getDescription());

    }

    @Override
    public int getItemCount() {

        return product2List.size();

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
