package com.example.newapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button cancelBtn;
    FoodModel food=new FoodModel();
    EditText email, password;
    List<FoodModel> foods;
    ListView listPersons;

    Intent intent = getIntent();

    ActivityResultLauncher<Intent> itemClickLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cancelBtn=findViewById(R.id.cancel_btn);
        listPersons=findViewById(R.id.customListView);




        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, LoginActivity.class);

                finish();
            }
        });

        apiInterface apiFoodInterface= ServiceActivity.buildService(apiInterface.class);
        Call<List<FoodModel>> requestForAllFoods= apiFoodInterface.getAllFoods();
        requestForAllFoods.enqueue(new Callback<List<FoodModel>>() {
            @Override
            public void onResponse(Call<List<FoodModel>> call, Response<List<FoodModel>> response) {
                foods =response.body();

                // Log.d("Persons:" ,persons.get(1).navn);
                FoodAdapter foodAdapter= new FoodAdapter( foods, MainActivity.this);
                listPersons.setAdapter(foodAdapter);
            }

            @Override
            public void onFailure(Call<List<FoodModel>> call, Throwable t) {
                Log.d("Foods:", t.getMessage().toString());
            }
        });

        listPersons= findViewById(R.id.customListView);
        listPersons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                food = foods.get(position);
                int idClick = foods.get(position).id;
                Log.d("Food:" ,food.name);
                intent = new Intent(MainActivity.this,Show_item_detail.class);
                intent.putExtra("food",food);
                //secondLauncher.launch(intent);
                //startActivity(intent);
                itemClickLauncher.launch(intent);
            }


        });
        itemClickLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result)
                    {
                        if(result.getResultCode() == Activity.RESULT_OK)
                        {
                            startActivity(intent);

                        }
                    }
                });
    }
}