package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.adapters.Product1Adapter;
import com.example.nutritec.adapters.Product2Adapter;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodConsumptionAddProductActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText servingsText;

    private Button goBackButton;

    // Global variables
    private List<Product> productList;

    private static int servings;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption_add_product);

        // Variables assignment to control XML items
        servingsText = findViewById(R.id.editTextFoodConsumptionAddProductServings);

        recyclerView = findViewById(R.id.recyclerViewFoodConsumptionAddProduct);
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

        PR10(MainActivity.getPatient().getEmail(), FoodConsumptionActivity.getDay(), FoodConsumptionActivity.getMeal());

        Product2Adapter product2Adapter = new Product2Adapter(FoodConsumptionAddProductActivity.this, productList);

        recyclerView.setAdapter(product2Adapter);

        goBackButton = (Button) findViewById(R.id.buttonFoodConsumptionAddProductGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToFoodConsumptionActivity();

            }

        });

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductRestAPI productRestAPI = retrofit.create(ProductRestAPI.class);

        Call<List<Product>> getCall = productRestAPI.PR10(email, day, meal);
        getCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, retrofit2.Response<List<Product>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Product> productListResponse = response.body();

                        setProductList(productListResponse);

                    } else {

                        Toast.makeText(FoodConsumptionAddProductActivity.this, "Error: Products GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(FoodConsumptionAddProductActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                Toast.makeText(FoodConsumptionAddProductActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

















}