package com.example.nutritec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritec.R;
import com.example.nutritec.models.Recipe;

import java.util.List;

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

        holder.number.setText("Number: " + recipe.getNumber());
        holder.name.setText("Name: " + recipe.getName());

        holder.addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                // REST API RE.2 METHOD






            }
        });

    }

    @Override
    public int getItemCount() {

        return recipeList.size();

    }

    public class Recipe1ViewHolder extends RecyclerView.ViewHolder {

        TextView number;
        TextView name;

        Button addRecipe;

        public Recipe1ViewHolder(@NonNull View itemView) {

            super(itemView);

            number = itemView.findViewById(R.id.textViewRecipeItem1Number);
            name = itemView.findViewById(R.id.textViewRecipeItem1Name);

            addRecipe = itemView.findViewById(R.id.buttonRecipeItem1AddRecipe);

        }

    }

}
