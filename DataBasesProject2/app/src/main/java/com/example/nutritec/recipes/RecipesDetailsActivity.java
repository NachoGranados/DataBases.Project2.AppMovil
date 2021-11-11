package com.example.nutritec.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nutritec.R;

public class RecipesDetailsActivity extends AppCompatActivity {

    // Variables to control XML items
    private TextView recipeNameText;

    private Button goBackButton;
    private Button addProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_details);

        // Variables assignment to control XML items
        recipeNameText = findViewById(R.id.textViewRecipesDetailsRecipeName);

        goBackButton = (Button) findViewById(R.id.buttonRecipesDetailsGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToRecipesActivity();

            }

        });

        addProductButton = (Button) findViewById(R.id.buttonRecipesDetailsAddProduct);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRecipesAddProductActivity();

            }

        });

    }

    private void goBackToRecipesActivity() {

        this.finish();

    }

    // Opens the activity where the user can add products to a recipe
    private void openRecipesAddProductActivity() {

        Intent intent = new Intent(this, RecipesAddProductActivity.class);
        startActivity(intent);

    }

}