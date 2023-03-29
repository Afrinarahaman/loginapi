package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    PersonModel person1=new PersonModel();
    Button cancelBtn,regisBtn;
    EditText txtEmail, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

      cancelBtn=findViewById(R.id.cancelBtn);
      regisBtn= findViewById(R.id.registrationBtn);
      txtEmail=findViewById(R.id.txtemail);
      txtPass=findViewById(R.id.txtpassword);




        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person1.email=txtEmail.getText().toString();
                person1.password = txtPass.getText().toString();
                if (person1.email.matches(""))
                {
                    Toast.makeText(RegistrationActivity.this, "You did not enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (person1.password.matches(""))
                {
                    Toast.makeText(RegistrationActivity.this, "You did not enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                registerPerson(person1);
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void registerPerson(PersonModel person1) {
        apiInterface personAPI = ServiceActivity.buildService(apiInterface.class);
        Call <PersonResponse> request=personAPI.registerPerson(person1);
        request.enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call <PersonResponse>call, Response<PersonResponse> response) {
                PersonResponse Response = response.body();

               if(Response != null && Response.message.equals(person1.getEmail())) {
                    Toast.makeText(RegistrationActivity.this, "Has been registered", Toast.LENGTH_LONG).show();
                    finish();

                }
                else Toast.makeText(RegistrationActivity.this, "Not registered", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call <PersonResponse>call, Throwable t) {
                Toast.makeText(RegistrationActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}