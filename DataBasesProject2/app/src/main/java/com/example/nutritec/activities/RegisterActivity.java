package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nutritec.R;

public class RegisterActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText emailText;
    private EditText usernameText;
    private EditText firstNameText;
    private EditText lastName1Text;
    private EditText lastName2Text;
    private EditText birthDateText;
    private EditText passwordText;

    private EditText dateText;
    private EditText heightText;
    private EditText weightText;
    private EditText hipsText;
    private EditText waistText;
    private EditText neckText;
    private EditText fatPercentageText;
    private EditText musclePercentageText;

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Variables assignment to control XML items
        emailText = findViewById(R.id.editTextRegisterEmail);
        usernameText = findViewById(R.id.editTextRegisterUsername);
        lastName1Text = findViewById(R.id.editTextRegisterLastName1);
        lastName2Text = findViewById(R.id.editTextRegisterLastName2);
        birthDateText = findViewById(R.id.editTextRegisterBirthDate);
        passwordText = findViewById(R.id.editTextRegisterPassword);

        dateText = findViewById(R.id.editTextRegisterDate);
        heightText = findViewById(R.id.editTextRegisterHeight);
        weightText = findViewById(R.id.editTextRegisterWeight);
        hipsText = findViewById(R.id.editTextRegisterHips);
        waistText = findViewById(R.id.editTextRegisterWaist);
        neckText = findViewById(R.id.editTextRegisterNeck);
        fatPercentageText = findViewById(R.id.editTextRegisterFatPercentage);
        musclePercentageText = findViewById(R.id.editTextRegisterMusclePercentage);

        registerButton = (Button) findViewById(R.id.buttonRegisterRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLoginActivity();

            }

        });

    }

    // Opens the activity where the user can verify his or her account
    private void openLoginActivity() {

        this.finish();

    }

}