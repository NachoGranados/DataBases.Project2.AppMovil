package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.adapters.Recipe1Adapter;
import com.example.nutritec.adapters.Recipe2Adapter;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Recipe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipesActivity extends AppCompatActivity {

    // Variables to control XML items
    DrawerLayout drawerLayout;

    private Button addRecipeButton;
    private Button searchButton;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        // Variables assignment to control XML items
        drawerLayout = findViewById(R.id.drawer_layout);

        addRecipeButton = (Button) findViewById(R.id.buttonRecipesAddRecipe);
        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRecipesAddRecipeActivity();

            }

        });

        searchButton = (Button) findViewById(R.id.buttonRecipesAddSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RE1(MainActivity.getPatient().getEmail());

            }

        });

        recyclerView = findViewById(R.id.recyclerViewRecipes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RE1(MainActivity.getPatient().getEmail());

    }

    // Opens the activity where the user can create a new recipe
    private void openRecipesAddRecipeActivity() {

        Intent intent = new Intent(this, RecipesAddRecipeActivity.class);
        startActivity(intent);

    }

    public void ClickMenu(View view) {

        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view) {

        MainActivity.closeDrawer(drawerLayout);

    }

    public void ClickHome(View view) {

        // Finish activity
        this.finish();

        // Redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);

    }

    public void ClickFoodConsumption(View view) {

        // Finish activity
        this.finish();

        // Redirect activity to food consumption
        MainActivity.redirectActivity(this, FoodConsumptionActivity.class);

    }

    public void ClickRecipes(View view) {

        // Recreate activity
        recreate();

    }

    public void ClickLogout(View view) {

        // Close app
        MainActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Close drawer
        MainActivity.closeDrawer(drawerLayout);

    }

    // Gets recipes information from Rest API
    private void RE1(String email) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<List<Recipe>> getCall = recipeRestAPI.RE1(email);
        getCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, retrofit2.Response<List<Recipe>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Recipe> recipeListResponse = response.body();

                        Recipe2Adapter recipe2Adapter = new Recipe2Adapter(RecipesActivity.this, recipeListResponse);

                        recyclerView.setAdapter(recipe2Adapter);

                    } else {

                        Toast.makeText(RecipesActivity.this, "Error: Recipes GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RecipesActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

                Toast.makeText(RecipesActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

}