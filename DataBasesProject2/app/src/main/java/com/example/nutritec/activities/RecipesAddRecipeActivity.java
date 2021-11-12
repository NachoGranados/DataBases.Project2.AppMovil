package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Recipe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

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

                String name = recipeNameText.getText().toString();

                RE3(name, MainActivity.getPatient().getEmail());

                goBackToRecipesActivity();

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

    // Posts the given recipe into the Rest API
    private void RE3(String name, String email) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<Void> getCall = recipeRestAPI.RE3(name, email);
        getCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, retrofit2.Response<Void> response) {

                try {

                    if (response.isSuccessful()) {

                        Toast.makeText(RecipesAddRecipeActivity.this, "Recipe Creation Successful", Toast.LENGTH_SHORT).show();

                        recipeNameText.setText("");

                        goBackToRecipesActivity();

                    } else {

                        Toast.makeText(RecipesAddRecipeActivity.this, "Error: Recipe POST Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RecipesAddRecipeActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(RecipesAddRecipeActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

}