package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Show_item_detail extends AppCompatActivity {
    Button cancelBtn;
    FoodModel food=new FoodModel();
    ImageView itemImage;
    TextView txtName, txtPrice, txtCategoryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item_detail);

        cancelBtn=findViewById(R.id.btnCancel);
        txtName=findViewById(R.id.txtName);
        txtPrice=findViewById(R.id.txtPrice);
        txtCategoryName=findViewById(R.id.txtCategoryName);
        itemImage=findViewById(R.id.itemImage);

        food = (FoodModel) getIntent().getSerializableExtra("food");

        txtName.setText(food.getName());
        txtPrice.setText(String.valueOf(food.getPrice()));
        txtCategoryName.setText((food.getCategoryName()));
        apiImageInterface apiImageInterface= ServiceActivity.buildService(apiImageInterface.class);
        Call<ResponseBody> request = apiImageInterface.GetImage(food.getImage());

        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                ResponseBody body = response.body();
                InputStream bis = new BufferedInputStream(body.byteStream(), 1024 * 8);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                itemImage.setImageBitmap(bitmap);
                // Log.d("Persons:" ,persons.get(1).navn);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Foods:", t.getMessage().toString());
            }
        });


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Show_item_detail.this, MainActivity.class);

                finish();
            }
        });

    }
}