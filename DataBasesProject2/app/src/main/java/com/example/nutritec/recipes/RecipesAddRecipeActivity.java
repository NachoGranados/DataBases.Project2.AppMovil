package com.example.nutritec.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nutritec.R;

public class RecipesAddRecipeActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText recipeNameText;

    private Button createButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_add_recipe);

        // Variables assignment to control XML items
        recipeNameText = findViewById(R.id.editTextRecipesAddRecipeRecipeName);

        createButton = (Button) findViewById(R.id.buttonRecipesAddRecipeCreate);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //openMainActivity();

            }

        });

        cancelButton = (Button) findViewById(R.id.buttonRecipesAddRecipeCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToRecipesActivity();

            }

        });

    }

    private void goBackToRecipesActivity() {

        this.finish();

    }

}