package com.example.nutritec.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritec.R;
import com.example.nutritec.interfaces.MeasurementRestAPI;
import com.example.nutritec.interfaces.PatientRestAPI;
import com.example.nutritec.models.Measurement;
import com.example.nutritec.models.Patient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    // Variables to control XML items
    private EditText emailText;
    private EditText usernameText;
    private EditText firstNameText;
    private EditText lastName1Text;
    private EditText lastName2Text;
    private EditText birthDateText;
    private EditText passwordText;

    /*
    private EditText dateText;
    private EditText heightText;
    private EditText weightText;
    private EditText hipsText;
    private EditText waistText;
    private EditText neckText;
    private EditText fatPercentageText;
    private EditText musclePercentageText;
     */

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Variables assignment to control XML items
        emailText = findViewById(R.id.editTextRegisterEmail);
        usernameText = findViewById(R.id.editTextRegisterUsername);
        firstNameText = findViewById(R.id.editTextRegisterFirstName);
        lastName1Text = findViewById(R.id.editTextRegisterLastName1);
        lastName2Text = findViewById(R.id.editTextRegisterLastName2);
        birthDateText = findViewById(R.id.editTextRegisterBirthDate);
        passwordText = findViewById(R.id.editTextRegisterPassword);

        /*
        dateText = findViewById(R.id.editTextRegisterDate);
        heightText = findViewById(R.id.editTextRegisterHeight);
        weightText = findViewById(R.id.editTextRegisterWeight);
        hipsText = findViewById(R.id.editTextRegisterHips);
        waistText = findViewById(R.id.editTextRegisterWaist);
        neckText = findViewById(R.id.editTextRegisterNeck);
        fatPercentageText = findViewById(R.id.editTextRegisterFatPercentage);
        musclePercentageText = findViewById(R.id.editTextRegisterMusclePercentage);
        */

        registerButton = (Button) findViewById(R.id.buttonRegisterRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailText.getText().toString();
                String username = usernameText.getText().toString();
                String firstName = firstNameText.getText().toString();
                String lastName1 = lastName1Text.getText().toString();
                String lastName2 = lastName2Text.getText().toString();
                String birthDate = birthDateText.getText().toString();
                String password = passwordText.getText().toString();

                /*
                String date = dateText.getText().toString();
                String height = heightText.getText().toString();
                String weight = weightText.getText().toString();
                String hips = hipsText.getText().toString();
                String waist = waistText.getText().toString();
                String neck = neckText.getText().toString();
                String fatPercentage = fatPercentageText.getText().toString();
                String musclePercentage = musclePercentageText.getText().toString();

                 */

                if(!email.equals("") && !username.equals("") && !firstName.equals("") &&
                   !lastName1.equals("") && !lastName2.equals("") && !birthDate.equals("") &&
                   !password.equals("")) { //&& !date.equals("") && !height.equals("") &&
                   //!weight.equals("") && !hips.equals("") && !waist.equals("") &&
                   //!neck.equals("") && !fatPercentage.equals("") && !musclePercentage.equals("")) {

                    Patient patient = new Patient();

                    patient.setEmail(email);
                    patient.setUsername(username);
                    patient.setFirstName(firstName);
                    patient.setLastName1(lastName1);
                    patient.setLastName2(lastName2);
                    patient.setBirthDate(birthDate);
                    patient.setPassowrd(password);

                    PA2(patient);

                    /*

                    Measurement measurement = new Measurement();

                    measurement.setDate(date);
                    measurement.setPatientEmail(email);
                    measurement.setHeight(Float.parseFloat(height));
                    measurement.setWeight(Float.parseFloat(weight));
                    measurement.setHips(Float.parseFloat(hips));
                    measurement.setWaist(Float.parseFloat(waist));
                    measurement.setNeck(Float.parseFloat(neck));
                    measurement.setFatPercentage(Float.parseFloat(fatPercentage));
                    measurement.setMusclePercentage(Float.parseFloat(musclePercentage));

                    ME3(measurement);

                    */

                } else {

                    Toast.makeText(RegisterActivity.this, "Complete all the information", Toast.LENGTH_SHORT).show();

                }

            }

        });

    }

    // Opens the activity where the user can verify his or her account
    private void openLoginActivity() {

        this.finish();

    }

    // Posts the given patient information into the REST API
    private void PA2(Patient patient) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        PatientRestAPI patientRestAPI = retrofit.create(PatientRestAPI.class);

        Call<Void> postCall = patientRestAPI.PA2(patient);
        postCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, retrofit2.Response<Void> response) {

                try {

                    if (response.isSuccessful()) {

                        Toast.makeText(RegisterActivity.this, "Successful Register Patient", Toast.LENGTH_SHORT).show();

                        openLoginActivity();

                    } else {

                        Toast.makeText(RegisterActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RegisterActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(RegisterActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    // Posts the given measurement information into the REST API
    private void ME3(Measurement measurement) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nutritecrg.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MeasurementRestAPI measurementRestAPI = retrofit.create(MeasurementRestAPI.class);

        Call<Void> postCall = measurementRestAPI.ME3(measurement);
        postCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, retrofit2.Response<Void> response) {

                try {

                    if (response.isSuccessful()) {

                        Toast.makeText(RegisterActivity.this, "Successful Register Measurement", Toast.LENGTH_SHORT).show();

                        openLoginActivity();

                    } else {

                        Toast.makeText(RegisterActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception exception) {

                    Toast.makeText(RegisterActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(RegisterActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }



}