package com.example.nutritec.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.activities.RecipesActivity;
import com.example.nutritec.activities.RecipesDetailsActivity;
import com.example.nutritec.activities.RegisterActivity;
import com.example.nutritec.models.Recipe;

import java.util.List;

public class Recipe2Adapter extends RecyclerView.Adapter<Recipe2Adapter.Recipe2ViewHolder> {

    Context context;
    List<Recipe> recipeList;

    public Recipe2Adapter(Context context, List<Recipe> recipeList) {

        this.context = context;
        this.recipeList = recipeList;

    }

    @NonNull
    @Override
    public Recipe2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recipe_item_2, parent, false);

        return new Recipe2Adapter.Recipe2ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Recipe2ViewHolder holder, int position) {

        Recipe recipe = recipeList.get(position);

        holder.numberTextView.setText("Number: " + recipe.getNumber());
        holder.nameTextView.setText("Name: " + recipe.getName());

        holder.addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRecipesDetailsActivity();

            }
        });

    }

    @Override
    public int getItemCount() {

        return recipeList.size();

    }

    public class Recipe2ViewHolder extends RecyclerView.ViewHolder {

        TextView numberTextView;
        TextView nameTextView;

        Button addRecipeButton;

        public Recipe2ViewHolder(@NonNull View itemView) {

            super(itemView);

            numberTextView = itemView.findViewById(R.id.textViewRecipeItem2Number);
            nameTextView = itemView.findViewById(R.id.textViewRecipeItem2Name);

            addRecipeButton = itemView.findViewById(R.id.buttonRecipeItem2Details);

        }

    }

    // Opens the activity where the user can see the details for the selected recipe
    private void openRecipesDetailsActivity() {

        Intent intent = new Intent(context, RecipesDetailsActivity.class);
        context.startActivity(intent);

    }

}
