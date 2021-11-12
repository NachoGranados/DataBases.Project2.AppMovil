package com.example.nutritec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.activities.FoodConsumptionActivity;
import com.example.nutritec.activities.FoodConsumptionAddRecipeActivity;
import com.example.nutritec.activities.MainActivity;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.interfaces.RecipeRestAPI;
import com.example.nutritec.models.Product;
import com.example.nutritec.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class Recipe1Adapter extends RecyclerView.Adapter<Recipe1Adapter.Recipe1ViewHolder> {

    Context context;
    List<Recipe> recipeList;

    public Recipe1Adapter(Context context, List<Recipe> recipeList) {

        this.context = context;
        this.recipeList = recipeList;

    }

    @NonNull
    @Override
    public Recipe1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recipe_item_1, parent, false);

        return new Recipe1Adapter.Recipe1ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Recipe1ViewHolder holder, int position) {

        Recipe recipe = recipeList.get(position);

        holder.numberTextView.setText("Number: " + recipe.getNumber());
        holder.nameTextView.setText("Name: " + recipe.getName());

        holder.addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RE2(recipe.getNumber(),
                    MainActivity.getPatient().getEmail(),
                    FoodConsumptionActivity.getDay(),
                    FoodConsumptionActivity.getMeal());

            }
        });

    }

    @Override
    public int getItemCount() {

        return recipeList.size();

    }

    public class Recipe1ViewHolder extends RecyclerView.ViewHolder {

        TextView numberTextView;
        TextView nameTextView;

        Button addRecipeButton;

        public Recipe1ViewHolder(@NonNull View itemView) {

            super(itemView);

            numberTextView = itemView.findViewById(R.id.textViewRecipeItem1Number);
            nameTextView = itemView.findViewById(R.id.textViewRecipeItem1Name);

            addRecipeButton = itemView.findViewById(R.id.buttonRecipeItem1AddRecipe);

        }

    }

    // Posts the given recipe into the Rest API
    private void RE2(int number, String email, String day, String meal) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RecipeRestAPI recipeRestAPI = retrofit.create(RecipeRestAPI.class);

        Call<Recipe> getCall = recipeRestAPI.RE2(number, email, day, meal);
        getCall.enqueue(new Callback<Recipe>() {
            @Override
            public void onResponse(Call<Recipe> call, retrofit2.Response<Recipe> response) {

                try {

                    if (response.isSuccessful()) {

                        Toast.makeText(context, "Recipe Addition Successful", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(context, "Error: Recipe POST Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Recipe> call, Throwable t) {

                Toast.makeText(context, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });


    }

}
