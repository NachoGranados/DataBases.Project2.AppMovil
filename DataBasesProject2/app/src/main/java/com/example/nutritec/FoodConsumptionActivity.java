package com.example.nutritec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class FoodConsumptionActivity extends AppCompatActivity {

    // Variables to control XML items
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption);

        // Variables assignment to control XML items
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view) {

        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view) {

        MainActivity.closeDrawer(drawerLayout);

    }

    public void ClickHome(View view) {

        // Redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);

    }

    public void ClickFoodConsumption(View view) {

        // Recreate activity
        recreate();

    }

    public void ClickRecipes(View view) {

        // Redirect activity to recipes
        MainActivity.redirectActivity(this, RecipesActivity.class);

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