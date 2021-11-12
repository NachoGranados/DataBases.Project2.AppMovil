package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.adapters.Recipe1Adapter;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Recipe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodConsumptionAddRecipeActivity extends AppCompatActivity {

    // Variables to control XML items
    private Button goBackButton;

    private List<Recipe> recipeList;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption_add_recipe);

        // Variables assignment to control XML items
        recyclerView = findViewById(R.id.recyclerViewFoodConsumptionAddRecipe);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipeList = new ArrayList<>();

        // QUITAR
        for(int i = 0; i < 5; i++) {

            Recipe recipe = new Recipe();

            recipe.setNumber(i);
            recipe.setName("Pinto");

            recipeList.add(recipe);

        }

        RE7(MainActivity.getPatient().getEmail(), FoodConsumptionActivity.getDay(), FoodConsumptionActivity.getMeal());

        Recipe1Adapter recipe1Adapter = new Recipe1Adapter(FoodConsumptionAddRecipeActivity.this, recipeList);

        recyclerView.setAdapter(recipe1Adapter);

        // Variables assignment to control XML items
        goBackButton = (Button) findViewById(R.id.buttonFoodConsumptionAddRecipeGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToFoodConsumptionActivity();

            }

        });

    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    private void goBackToFoodConsumptionActivity() {

        this.finish();

    }

    // Gets recipes information from Rest API
    private void RE7(String email, String day, String meal) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<List<Recipe>> getCall = recipeRestAPI.RE7(email, day, meal);
        getCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, retrofit2.Response<List<Recipe>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Recipe> recipeListResponse = response.body();

                        setRecipeList(recipeListResponse);

                    } else {

                        Toast.makeText(FoodConsumptionAddRecipeActivity.this, "Error: Recipes GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(FoodConsumptionAddRecipeActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

                Toast.makeText(FoodConsumptionAddRecipeActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }






















}