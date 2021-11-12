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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

                PA1(patientEmail);

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

    private String MD5Encryption(String passwordToHash) {

        String generatedPassword = null;

        try {

            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;

    }

    // Gets the patient information from the REST API
    private void PA1(String credential) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        PatientRestAPI patientRestAPI = retrofit.create(PatientRestAPI.class);

        Call<Patient> getCall = patientRestAPI.PA1(credential);
        getCall.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, retrofit2.Response<Patient> response) {

                try {

                    if (response.isSuccessful()) {

                        Patient patient = response.body();

                        String passwordEncrypted = MD5Encryption(passwordText.getText().toString());

                        if (passwordEncrypted.equals(patient.getPassowrd())) {

                            Toast.makeText(LoginActivity.this, "Successful Login", Toast.LENGTH_SHORT).show();

                            openMainActivity(patient);

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