package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.adapters.Product2Adapter;
import com.example.nutritec.adapters.Product3Adapter;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Product;
import com.example.nutritec.models.Recipe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RecipesDetailsActivity extends AppCompatActivity {

    // Variables to control XML items
    private TextView recipeNameText;

    private Button goBackButton;
    private Button addProductButton;

    private List<Product> productList;

    private RecyclerView recyclerView;

    // Global variables
    private static String name;
    private static int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_details);

        // Variables assignment to control XML items
        recipeNameText = findViewById(R.id.textViewRecipesDetailsRecipeName);
        recipeNameText.setText("Recipe: " + name);

        recyclerView = findViewById(R.id.recyclerViewRecipesDetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        // QUITAR
        for(int i = 0; i < 5; i++) {

            Product product = new Product();

            product.setBarcode(i);
            product.setName("Rice");
            product.setDescription("A serving of rice");

            productList.add(product);

        }

        RE4(number);

        Product3Adapter product3Adapter = new Product3Adapter(RecipesDetailsActivity.this, productList);

        recyclerView.setAdapter(product3Adapter);

        goBackButton = (Button) findViewById(R.id.buttonRecipesDetailsGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToRecipesActivity();

            }

        });

        addProductButton = (Button) findViewById(R.id.buttonRecipesDetailsAddProduct);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRecipesAddProductActivity();

            }

        });

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        RecipesDetailsActivity.name = name;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        RecipesDetailsActivity.number = number;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private void goBackToRecipesActivity() {

        this.finish();

    }

    // Opens the activity where the user can add products to a recipe
    private void openRecipesAddProductActivity() {

        Intent intent = new Intent(this, RecipesAddProductActivity.class);
        startActivity(intent);

    }

    // Gets products information from Rest API
    private void RE4(int number) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<List<Product>> getCall = recipeRestAPI.RE4(number);
        getCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, retrofit2.Response<List<Product>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Product> productListResponse = response.body();

                        setProductList(productListResponse);

                    } else {

                        Toast.makeText(RecipesDetailsActivity.this, "Error: Products GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RecipesDetailsActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                Toast.makeText(RecipesDetailsActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

}