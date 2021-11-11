package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nutritec.R;

public class FoodConsumptionActivity extends AppCompatActivity {

    // Variables to control XML items
    DrawerLayout drawerLayout;

    private Button mondayButton;
    private Button tuesdayButton;
    private Button wednesdayButton;
    private Button thursdayButton;
    private Button fridayButton;

    private Button breakfastButton;
    private Button morningSnackButton;
    private Button lunchButton;
    private Button afternoonSnackButton;
    private Button dinnerButton;

    TextView dayTextView;
    TextView mealTextView;

    private TextView feedbackContentTextView;

    private Button sendButton;
    private Button addProductButton;
    private Button addRecipeButton;

    // Global variables
    private String day;
    private String meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption);

        // Variables assignment to control XML items
        drawerLayout = findViewById(R.id.drawer_layout);

        mondayButton = (Button) findViewById(R.id.buttonFoodConsumptionMonday);
        mondayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                day = "Monday";

                dayTextView.setText("Day: Monday");

            }

        });

        tuesdayButton = (Button) findViewById(R.id.buttonFoodConsumptionTuesday);
        tuesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                day = "Tuesday";

                dayTextView.setText("Day: Tuesday");

            }

        });

        wednesdayButton = (Button) findViewById(R.id.buttonFoodConsumptionWednesday);
        wednesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                day = "Wednesday";

                dayTextView.setText("Day: Wednesday");

            }

        });

        thursdayButton = (Button) findViewById(R.id.buttonFoodConsumptionThursday);
        thursdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                day = "Thursday";

                dayTextView.setText("Day: Thursday");

            }

        });

        fridayButton = (Button) findViewById(R.id.buttonFoodConsumptionFriday);
        fridayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                day = "Friday";

                dayTextView.setText("Day: Friday");

            }

        });

        breakfastButton = (Button) findViewById(R.id.buttonFoodConsumptionBreakfast);
        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                meal = "Breakfast";

                mealTextView.setText("Meal: Breakfast");

            }

        });

        morningSnackButton = (Button) findViewById(R.id.buttonFoodConsumptionMorningSnack);
        morningSnackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                meal = "Morning snack";

                mealTextView.setText("Meal: Morning snack");

            }

        });

        lunchButton = (Button) findViewById(R.id.buttonFoodConsumptionLunch);
        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                meal = "Lunch";

                mealTextView.setText("Meal: Lunch");

            }

        });

        afternoonSnackButton = (Button) findViewById(R.id.buttonFoodConsumptionAfternoonSnack);
        afternoonSnackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                meal = "Afternoon snack";

                mealTextView.setText("Meal: Afternoon snack");

            }

        });

        dinnerButton = (Button) findViewById(R.id.buttonFoodConsumptionDinner);
        dinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                meal = "Diner";

                mealTextView.setText("Meal: Dinner");

            }

        });

        dayTextView = findViewById(R.id.textViewFoodConsumptionDay);
        mealTextView = findViewById(R.id.textViewFoodConsumptionMeal);

        feedbackContentTextView = findViewById(R.id.textViewFoodConsumptionFeedbackContent);
        feedbackContentTextView.setMovementMethod(new ScrollingMovementMethod());

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