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
import com.example.nutritec.adapters.Product3Adapter;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Product2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipesDetailsActivity extends AppCompatActivity {

    // Variables to control XML items
    private TextView recipeNameText;

    private Button searchButton;
    private Button goBackButton;
    private Button addProductButton;

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

        searchButton = (Button) findViewById(R.id.buttonRecipesDetailsSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RE4(number);

            }

        });

        recyclerView = findViewById(R.id.recyclerViewRecipesDetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RE4(number);

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

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<List<Product2>> getCall = recipeRestAPI.RE4(number);
        getCall.enqueue(new Callback<List<Product2>>() {
            @Override
            public void onResponse(Call<List<Product2>> call, retrofit2.Response<List<Product2>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Product2> product2ListResponse = response.body();

                        Product3Adapter product3Adapter = new Product3Adapter(RecipesDetailsActivity.this, product2ListResponse);

                        recyclerView.setAdapter(product3Adapter);

                    } else {

                        Toast.makeText(RecipesDetailsActivity.this, "Error: Products GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RecipesDetailsActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Product2>> call, Throwable t) {

                Toast.makeText(RecipesDetailsActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

}