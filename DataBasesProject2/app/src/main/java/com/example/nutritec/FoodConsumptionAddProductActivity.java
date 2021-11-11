package com.example.nutritec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FoodConsumptionAddProductActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText servingsText;

    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_consumption_add_product);

        // Variables assignment to control XML items
        servingsText = findViewById(R.id.editTextFoodConsumptionAddProductServings);

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

}