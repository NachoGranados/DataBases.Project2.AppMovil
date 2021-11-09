package com.example.nutritec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText emailText;
    private EditText passwordText;

    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Variables assignment to control XML items
        emailText = findViewById(R.id.editTextLoginEmail);
        passwordText = findViewById(R.id.editTextLoginPassword);

        loginButton = (Button) findViewById(R.id.buttonLoginLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity();

            }

        });

        registerButton = (Button) findViewById(R.id.buttonLoginRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRegisterActivity();

            }

        });

    }

    // Opens the activity where the user can register a new account
    private void openRegisterActivity() {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

    // Opens the activity where the user navigate through the app
    private void openMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}