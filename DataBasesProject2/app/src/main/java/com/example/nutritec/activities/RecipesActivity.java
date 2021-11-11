package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nutritec.R;

public class RecipesActivity extends AppCompatActivity {

    // Variables to control XML items
    DrawerLayout drawerLayout;

    private Button addRecipeButton;

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

    }

    // Opens the activity where the user can create a new recipe
    private void openRecipesAddRecipeActivity() {

        Intent intent = new Intent(this, RecipesDetailsActivity.class);
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

}