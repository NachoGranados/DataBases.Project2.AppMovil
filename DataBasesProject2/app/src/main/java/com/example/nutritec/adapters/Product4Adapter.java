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
import com.example.nutritec.activities.FoodConsumptionActivity;
import com.example.nutritec.activities.FoodConsumptionAddProductActivity;
import com.example.nutritec.activities.MainActivity;
import com.example.nutritec.activities.RecipesAddProductActivity;
import com.example.nutritec.activities.RecipesDetailsActivity;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Product;
import com.example.nutritec.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class Product4Adapter extends RecyclerView.Adapter<Product4Adapter.Product4ViewHolder> {

    Context context;
    List<Product> productList;

    public Product4Adapter(Context context, List<Product> productList) {

        this.context = context;
        this.productList = productList;

    }

    @NonNull
    @Override
    public Product4ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_2, parent, false);

        return new Product4Adapter.Product4ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Product4ViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.barcodeTextView.setText("Barcode: " + product.getBarcode());
        holder.nameTextView.setText("Name: " + product.getName());
        holder.descriptionTextView.setText("Description: " + product.getDescription());

        holder.addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Product Addition Successful", Toast.LENGTH_SHORT).show();

                RE6(RecipesDetailsActivity.getNumber(), product.getBarcode(), RecipesAddProductActivity.getServings());

            }
        });

    }

    @Override
    public int getItemCount() {

        return productList.size();

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

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<Product> postCall = recipeRestAPI.RE6(number, barcode, servings);
        postCall.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, retrofit2.Response<Product> response) {

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
            public void onFailure(Call<Product> call, Throwable t) {

                Toast.makeText(context, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
