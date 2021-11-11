package com.example.nutritec.food.consumption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nutritec.MainActivity;
import com.example.nutritec.R;
import com.example.nutritec.recipes.RecipesActivity;

public class FoodConsumptionActivity extends AppCompatActivity {

    // Variables to control XML items
    DrawerLayout drawerLayout;

    private TextView textViewFoodConsumptionFeedbackContent;

    private Button sendButton;
    private Button addProductButton;
    private Button addRecipeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption);

        // Variables assignment to control XML items
        drawerLayout = findViewById(R.id.drawer_layout);

        textViewFoodConsumptionFeedbackContent = findViewById(R.id.textViewFoodConsumptionFeedbackContent);
        textViewFoodConsumptionFeedbackContent.setMovementMethod(new ScrollingMovementMethod());

        sendButton = (Button) findViewById(R.id.buttonFoodConsumptionSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //openLoginActivity();

            }

        });

        addProductButton = (Button) findViewById(R.id.buttonFoodConsumptionAddProduct);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFoodConsumptionAddProductActivity();

            }

        });

        addRecipeButton = (Button) findViewById(R.id.buttonFoodConsumptionAddRecipe);
        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFoodConsumptionAddRecipeActivity();

            }

        });


    }

    // Opens the activity where the user can add products to his daily food consumption
    private void openFoodConsumptionAddProductActivity() {

        Intent intent = new Intent(this, FoodConsumptionAddProductActivity.class);
        startActivity(intent);

    }

    // Opens the activity where the user can add recipes to his daily food consumption
    private void openFoodConsumptionAddRecipeActivity() {

        Intent intent = new Intent(this, FoodConsumptionAddRecipeActivity.class);
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

        // Recreate the activity
        recreate();

    }

    public void ClickRecipes(View view) {

        // Finish activity
        this.finish();

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