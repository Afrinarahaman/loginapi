package com.example.newapp;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonIOException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    boolean isSuccess4=true;
    boolean isSuccess=true;
    EditText email, password;
    String em, pass;

    Button loginBtn,cancelBtn, regBtn;

    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginBtn =findViewById(R.id.loginBtn);
        cancelBtn=findViewById(R.id.cancelBtn);
        regBtn=findViewById(R.id.regBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.getText().clear();
                password.getText().clear();
            }
        });
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             em= email.getText().toString();
             pass=password.getText().toString();

             if(TextUtils.isEmpty(em))
             {
                 email.setError("Email is required");
                 return;
             }
             if(TextUtils.isEmpty(pass))
             {
                 password.setError("Password is required");
                 return;
             }

             getUser(em,pass);



            }

        });



    }


    private void getUser(String email, String password)
    {
        apiInterface apiset= ServiceActivity.buildService(apiInterface.class);
        Log.d("email-method", "" +email);
        LoginRequest req = new LoginRequest();
        req.setEmail(email);
        req.setPassword(password);
        Call<PersonResponse> loginCall= apiset.login(req);

        loginCall.enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse>response) {
                //
                PersonResponse Response = response.body();




                //Log.d("emailfor response", "" +person.email);
                //System.out.println("Response:"+response.body().toString());


               if (Response.status.equals(true)) {
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent (LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    //Toast.makeText(LoginActivity.this, "Failure", Toast.LENGTH_SHORT).show();

                } else Toast.makeText(LoginActivity.this, "Failure", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {


                Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });






    }

}