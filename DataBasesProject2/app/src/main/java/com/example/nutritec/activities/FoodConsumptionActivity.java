package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.adapters.Product1Adapter;
import com.example.nutritec.interfaces.CommentRestAPI;
import com.example.nutritec.interfaces.ProductRestAPI;
import com.example.nutritec.models.Comment;
import com.example.nutritec.models.Product1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private EditText commentEditText;

    private Button sendButton;
    private Button addProductButton;
    private Button addRecipeButton;

    // Global variables
    private static String day = "Monday";
    private static String meal = "Breakfast";

    private List<Product1> product1List;
    private List<Comment> commentList;

    private RecyclerView recyclerView;











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

        recyclerView = findViewById(R.id.recyclerViewFoodConsumption);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //product1List = new ArrayList<Product1>();

        /*
        // QUITAR
        for(int i = 0; i < 5; i++) {

            Product product = new Product();

            product.setBarcode(i);
            product.setName("Rice");

            productList.add(product);

        }

         */

        PR8(MainActivity.getPatient().getEmail(), day, meal);

        //Toast.makeText(FoodConsumptionActivity.this, Integer.toString(product1ListAux.size()), Toast.LENGTH_SHORT).show();






        //Toast.makeText(FoodConsumptionActivity.this, MainActivity.getPatient().getEmail() + "*" + day + "*" + meal, Toast.LENGTH_SHORT).show();

        //Toast.makeText(FoodConsumptionActivity.this, Integer.toString(product1List.size()), Toast.LENGTH_SHORT).show();

        //Product1Adapter product1Adapter = new Product1Adapter(FoodConsumptionActivity.this, product1List);

        //recyclerView.setAdapter(product1Adapter);

        feedbackContentTextView = findViewById(R.id.textViewFoodConsumptionFeedbackContent);
        feedbackContentTextView.setMovementMethod(new ScrollingMovementMethod());

        feedbackContentTextView.setText("");

        commentList = new ArrayList<>();

        CO2(MainActivity.getPatient().getEmail(), day, meal);






        // QUITAR

        //feedbackContentTextView.setText("");

        /*

        for(int i = 0; i < 5; i++) {

            Comment comment = new Comment();

            comment.setCommentText("Hola -> " + Integer.toString(i));

            commentList.add(comment);

        }



        String commentText = "";

        for(int i = 0; i < commentList.size(); i++) {

            commentText += commentList.get(i).getCommentText() + "\n";

        }



        feedbackContentTextView.setText(commentText);





         */





        commentEditText = findViewById(R.id.editTextFoodConsumptionComment);

        sendButton = (Button) findViewById(R.id.buttonFoodConsumptionSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Comment comment = new Comment();

                comment.setPatientEmail(MainActivity.getPatient().getEmail());
                comment.setDay(day);
                comment.setMeal(meal);
                comment.setCommentOwnerEmail(MainActivity.getPatient().getEmail());
                comment.setCommentText(commentEditText.getText().toString());

                CO3(comment);

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

    public static String getDay() {
        return day;
    }

    public static void setDay(String day) {
        FoodConsumptionActivity.day = day;
    }

    public static String getMeal() {
        return meal;
    }

    public static void setMeal(String meal) {
        FoodConsumptionActivity.meal = meal;
    }

    public List<Product1> getProduct1List() {
        return product1List;
    }

    public void setProduct1List(List<Product1> product1List) {
        this.product1List = product1List;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    // Gets products information from Rest API
    private void PR8(String email, String day, String meal) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        final List<Product1>[] product1ListAux = new List[]{new ArrayList<>()};

        ProductRestAPI productRestAPI = retrofit.create(ProductRestAPI.class);

        Call<List<Product1>> getCall = productRestAPI.PR8(email, day, meal);
        getCall.enqueue(new Callback<List<Product1>>() {
            @Override
            public void onResponse(Call<List<Product1>> call, Response<List<Product1>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Product1> product1ListResponse = response.body();

                        Product1Adapter product1Adapter = new Product1Adapter(FoodConsumptionActivity.this, product1ListResponse);

                        recyclerView.setAdapter(product1Adapter);

                    } else {

                        Toast.makeText(FoodConsumptionActivity.this, "Error: Products GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(FoodConsumptionActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Product1>> call, Throwable t) {

                Toast.makeText(FoodConsumptionActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

    // Gets patient comments
    private void CO2(String email, String day, String meal) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutriteccommentsrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        CommentRestAPI commentRestAPI = retrofit.create(CommentRestAPI.class);

        Call<List<Comment>> getCall = commentRestAPI.CO2(email, day, meal);
        getCall.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                try {

                    if (response.isSuccessful()) {

                        List<Comment> commentListResponse = response.body();

                        String commentText = "";

                        for(int i = 0; i < commentListResponse.size(); i++) {

                            commentText += commentListResponse.get(i).getCommentText() + "\n";

                        }

                        feedbackContentTextView.setText(commentText);

                    } else {

                        Toast.makeText(FoodConsumptionActivity.this, "Error: Comments GET Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(FoodConsumptionActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

                Toast.makeText(FoodConsumptionActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }

        });

    }

    // Posts the given comment into the Rest API
    private void CO3(Comment comment) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutriteccommentsrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        CommentRestAPI commentRestAPI = retrofit.create(CommentRestAPI.class);

        Call<Comment> postCall = commentRestAPI.CO3(comment);
        postCall.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, retrofit2.Response<Comment> response) {

                try {

                    if (response.isSuccessful()) {

                        String commentText = feedbackContentTextView.getText().toString() + comment.getCommentText() + "\n";

                        feedbackContentTextView.setText(commentText);

                        commentEditText.setText("");

                        Toast.makeText(FoodConsumptionActivity.this, "Comment Sent Successfully", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(FoodConsumptionActivity.this, "Error: Comment POST Failure", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(FoodConsumptionActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {

                Toast.makeText(FoodConsumptionActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

}