package com.example.nutritec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nutritec.food.consumption.FoodConsumptionActivity;
import com.example.nutritec.recipes.RecipesActivity;

public class MainActivity extends AppCompatActivity {

    // Variables to control XML items
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables assignment to control XML items
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view) {

        // Open drawer
        openDrawer(drawerLayout);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        // Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view) {

        // Close drawer
        closeDrawer(drawerLayout);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        // Close drawer layout
        if( drawerLayout.isDrawerOpen(GravityCompat.START)) {

            // When drawer is open, close it
            drawerLayout.closeDrawer(GravityCompat.START);

        }

    }

    public void ClickHome(View view) {

        // Recreate activity
        recreate();

    }

    public void ClickFoodConsumption(View view) {

        // Finish activity
        this.finish();

        // Redirect to food consumption
        redirectActivity(this, FoodConsumptionActivity.class);

    }

    public void ClickRecipes(View view) {

        // Finish activity
        this.finish();

        // Redirect to recipes
        redirectActivity(this, RecipesActivity.class);

    }

    public void ClickLogout(View view) {

        // Close app
        logout(this);

    }

    public static void logout(Activity activity) {

        // Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        // Set tittle
        builder.setTitle("Are you sure you want to logout?");

        // Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Finish activity
                activity.finish();

            }
        });

        // Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Dismiss dialog
                dialogInterface.dismiss();

            }
        });

        // Show dialog
        builder.show();

    }

    public static void redirectActivity(Activity activity, Class activityClass) {

        // Initialize intent
        Intent intent = new Intent(activity, activityClass);

        // Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Start activity
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Close drawer
        closeDrawer(drawerLayout);

    }
}














