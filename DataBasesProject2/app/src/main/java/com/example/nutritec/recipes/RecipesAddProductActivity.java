package com.example.nutritec.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nutritec.R;

public class RecipesAddProductActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText servingsText;

    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_add_product);

        // Variables assignment to control XML items
        servingsText = findViewById(R.id.editTextRecipesAddProductServings);

        goBackButton = (Button) findViewById(R.id.buttonRecipesAddProductGoBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBackToRecipesDetailsActivity();

            }

        });

    }

    private void goBackToRecipesDetailsActivity() {

        this.finish();

    }

}