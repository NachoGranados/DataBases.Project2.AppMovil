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
import com.example.nutritec.interfaces.CommentRestAPI;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.models.Comment;
import com.example.nutritec.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

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

        holder.barcodeTextView.setText("Barcode: " + product.getBarcode());
        holder.nameTextView.setText("Name: " + product.getName());
        holder.descriptionTextView.setText("Description: " + product.getDescription());

        holder.addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Product Addition Successful", Toast.LENGTH_SHORT).show();

                PR9(product.getBarcode(),
                    MainActivity.getPatient().getEmail(),
                    FoodConsumptionActivity.getDay(),
                    FoodConsumptionActivity.getMeal(),
                    FoodConsumptionAddProductActivity.getServings());

            }
        });

    }

    @Override
    public int getItemCount() {

        return productList.size();

    }

    public class Product2ViewHolder extends RecyclerView.ViewHolder {

        TextView barcodeTextView;
        TextView nameTextView;
        TextView descriptionTextView;

        Button addProductButton;

        public Product2ViewHolder(@NonNull View itemView) {

            super(itemView);

            barcodeTextView = itemView.findViewById(R.id.textViewProductItem2Barcode);
            nameTextView = itemView.findViewById(R.id.textViewProductItem2Name);
            descriptionTextView = itemView.findViewById(R.id.textViewProductItem2Description);

            addProductButton = itemView.findViewById(R.id.buttonProductItem2AddProduct);

        }

    }

    // Posts the given product into the Rest API
    private void PR9(int barcode, String email, String day, String meal, int servings) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductRestAPI productRestAPI = retrofit.create(ProductRestAPI.class);

        Call<Product> postCall = productRestAPI.PR9(barcode, email, day, meal, servings);
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
