package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nutritec.R;

public class FoodConsumptionAddRecipeActivity extends AppCompatActivity {

    // Variables to control XML items
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption_add_recipe);

        // Variables assignment to control XML items
        goBackButton = (Button) findViewById(R.id.buttonFoodConsumptionAddRecipeGoBack);
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

}