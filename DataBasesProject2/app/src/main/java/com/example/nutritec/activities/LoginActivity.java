package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.interfaces.PatientRestAPI;
import com.example.nutritec.models.Patient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

                String patientEmail = emailText.getText().toString();

                // GET PATIENT REST API METHOD
                //PA1(patientEmail);

                Patient patient = new Patient(); // QUITAR

                openMainActivity(patient);

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
    private void openMainActivity(Patient patient) {

        Intent intent = new Intent(this, MainActivity.class);

        MainActivity.setPatient(patient);

        startActivity(intent);

    }

    // Gets the patient information from the REST API
    private void PA1(String credential) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(GsonConverterFactory.create()).build();

        PatientRestAPI patientRestAPI = retrofit.create(PatientRestAPI.class);

        Call<Patient> getCall = patientRestAPI.PA1(credential);
        getCall.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, retrofit2.Response<Patient> response) {

                try {

                    if (response.isSuccessful()) {

                        Patient patient = response.body();

                        if (passwordText.getText().toString().equals(patient.getPassword())) {

                            Toast.makeText(LoginActivity.this, "Successful Login", Toast.LENGTH_SHORT).show();

                            // openMainActivity(patient);

                        } else {

                            Toast.makeText(LoginActivity.this, "Wrong Username or Password. Try Again", Toast.LENGTH_SHORT).show();

                        }

                    } else {

                        Toast.makeText(LoginActivity.this, "Wrong Username or Password. Try Again", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

}