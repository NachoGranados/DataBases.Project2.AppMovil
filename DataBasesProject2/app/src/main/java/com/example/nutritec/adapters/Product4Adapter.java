package com.example.nutritec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.activities.RecipesAddProductActivity;
import com.example.nutritec.activities.RecipesDetailsActivity;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Product2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Product4Adapter extends RecyclerView.Adapter<Product4Adapter.Product4ViewHolder> {

    Context context;
    List<Product2> product2List;

    public Product4Adapter(Context context, List<Product2> product2List) {

        this.context = context;
        this.product2List = product2List;

    }

    @NonNull
    @Override
    public Product4ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_2, parent, false);

        return new Product4Adapter.Product4ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product4ViewHolder holder, int position) {

        Product2 product2 = product2List.get(position);

        holder.barcodeTextView.setText("Barcode: " + product2.getBarcode());
        holder.nameTextView.setText("Name: " + product2.getName());
        holder.descriptionTextView.setText("Description: " + product2.getDescription());

        holder.addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Product Addition Successful", Toast.LENGTH_SHORT).show();

                RE6(RecipesDetailsActivity.getNumber(), product2.getBarcode(), RecipesAddProductActivity.getServings());

            }
        });

    }

    @Override
    public int getItemCount() {

        return product2List.size();

    }

    public class Product4ViewHolder extends RecyclerView.ViewHolder {

        TextView barcodeTextView;
        TextView nameTextView;
        TextView descriptionTextView;

        Button addProductButton;

        public Product4ViewHolder(@NonNull View itemView) {

            super(itemView);

            barcodeTextView = itemView.findViewById(R.id.textViewProductItem2Barcode);
            nameTextView = itemView.findViewById(R.id.textViewProductItem2Name);
            descriptionTextView = itemView.findViewById(R.id.textViewProductItem2Description);

            addProductButton = itemView.findViewById(R.id.buttonProductItem2AddProduct);

        }

    }

    // Posts the given product into the Rest API
    private void RE6(int number, int barcode, int servings) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<Void> postCall = recipeRestAPI.RE6(number, barcode, servings);
        postCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, retrofit2.Response<Void> response) {

                try {

                    if (response.isSuccessful()) {

                        Toast.makeText(context, "Product Addition Successful", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(context, "Error: Product POST Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(context, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
