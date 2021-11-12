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
import com.example.nutritec.adapters.Product2Adapter;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.models.Product2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodConsumptionAddProductActivity extends AppCompatActivity {

    // Variables to control XML items
    private TextView counterTextView;

    private ImageButton minusImageButton;
    private ImageButton plusImageButton;

    private Button goBackButton;

    // Global variables
    private static int servings = 1;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption_add_product);

        // Variables assignment to control XML items
        counterTextView = findViewById(R.id.textViewFoodConsumptionAddProductCounter);

        minusImageButton = findViewById(R.id.imageButtonFoodConsumptionAddProductMinus);
        minusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(servings > 1) {

                    servings--;

                }

                counterTextView.setText(Integer.toString(servings));

            }
        });

        plusImageButton = findViewById(R.id.imageButtonFoodConsumptionAddProductPlus);
        plusImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                servings++;

                counterTextView.setText(Integer.toString(servings));

            }
        });

        recyclerView = findViewById(R.id.recyclerViewFoodConsumptionAddProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PR10(MainActivity.getPatient().getEmail(), FoodConsumptionActivity.getDay(), FoodConsumptionActivity.getMeal());

        goBackButton = (Button) findViewById(R.id.buttonFoodConsumptionAddProductGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToFoodConsumptionActivity();

            }

        });

    }

    private void goBackToFoodConsumptionActivity() {

        this.finish();

    }

    public static int getServings() {
        return servings;
    }

    public static void setServings(int servings) {
        FoodConsumptionAddProductActivity.servings = servings;
    }

    // Gets products information from Rest API
    private void PR10(String email, String day, String meal) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductRestAPI productRestAPI = retrofit.create(ProductRestAPI.class);

        Call<List<Product2>> getCall = productRestAPI.PR10(email, day, meal);
        getCall.enqueue(new Callback<List<Product2>>() {
            @Override
            public void onResponse(Call<List<Product2>> call, retrofit2.Response<List<Product2>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Product2> product2ListResponse = response.body();

                        Product2Adapter product2Adapter = new Product2Adapter(FoodConsumptionAddProductActivity.this, product2ListResponse);

                        recyclerView.setAdapter(product2Adapter);

                    } else {

                        Toast.makeText(FoodConsumptionAddProductActivity.this, "Error: Products GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(FoodConsumptionAddProductActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Product2>> call, Throwable t) {

                Toast.makeText(FoodConsumptionAddProductActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

}