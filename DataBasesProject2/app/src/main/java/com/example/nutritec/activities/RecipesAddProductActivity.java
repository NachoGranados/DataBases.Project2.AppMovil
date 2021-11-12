package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.adapters.Product4Adapter;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Product2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipesAddProductActivity extends AppCompatActivity {

    // Variables to control XML items
    private TextView counterTextView;

    private ImageButton minusImageButton;
    private ImageButton plusImageButton;

    private Button goBackButton;

    // Global variables
    private List<Product2> product2List;

    private static int servings = 1;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_add_product);

        // Variables assignment to control XML items
        counterTextView = findViewById(R.id.textViewRecipesAddProductCounter);

        minusImageButton = findViewById(R.id.imageButtonRecipesAddProductMinus);
        minusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(servings > 1) {

                    servings--;

                }

                counterTextView.setText(Integer.toString(servings));

            }
        });

        plusImageButton = findViewById(R.id.imageButtonRecipesAddProductPlus);
        plusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                servings++;

                counterTextView.setText(Integer.toString(servings));

            }
        });

        recyclerView = findViewById(R.id.recyclerViewRecipesAddProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        product2List = new ArrayList<>();

        // QUITAR
        for(int i = 0; i < 5; i++) {

            Product2 product2 = new Product2();

            product2.setBarcode(i);
            product2.setName("Rice");
            product2.setDescription("A serving of rice");

            product2List.add(product2);

        }

        RE5(RecipesDetailsActivity.getNumber());

        Product4Adapter product4Adapter = new Product4Adapter(RecipesAddProductActivity.this, product2List);

        recyclerView.setAdapter(product4Adapter);

        goBackButton = (Button) findViewById(R.id.buttonRecipesAddProductGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToRecipesDetailsActivity();

            }

        });

    }

    public List<Product2> getProductList() {
        return product2List;
    }

    public void setProductList(List<Product2> product2List) {
        this.product2List = product2List;
    }

    public static int getServings() {
        return servings;
    }

    public static void setServings(int servings) {
        RecipesAddProductActivity.servings = servings;
    }

    private void goBackToRecipesDetailsActivity() {

        this.finish();

    }

    // Gets products information from Rest API
    private void RE5(int number) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<List<Product2>> getCall = recipeRestAPI.RE5(number);
        getCall.enqueue(new Callback<List<Product2>>() {
            @Override
            public void onResponse(Call<List<Product2>> call, retrofit2.Response<List<Product2>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Product2> product2ListResponse = response.body();

                        setProductList(product2ListResponse);

                    } else {

                        Toast.makeText(RecipesAddProductActivity.this, "Error: Products GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RecipesAddProductActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Product2>> call, Throwable t) {

                Toast.makeText(RecipesAddProductActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

}