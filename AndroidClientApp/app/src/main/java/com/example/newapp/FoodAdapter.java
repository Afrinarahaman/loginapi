package com.example.newapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodAdapter extends BaseAdapter {
    List<FoodModel> foods;
    Context context;

    public FoodAdapter(List<FoodModel> foods, Context context) {
        this.foods = foods;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v= inflater.inflate(R.layout.activity_show_food_item, null);
        FoodModel food=foods.get(position);

        TextView txtName= v.findViewById(R.id.txtName);
        txtName.setText(food.getName());

        TextView txtPrice= v.findViewById(R.id.txtPrice);
        txtPrice.setText(String.valueOf(food.getPrice())+"kr");
        ImageView image=v.findViewById(R.id.imageIcon);
       // image.(food.getImage());
        apiImageInterface apiImageInterface= ServiceActivity.buildService(apiImageInterface.class);
        Call<ResponseBody> request = apiImageInterface.GetImage(food.getImage());

        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                ResponseBody body = response.body();
                InputStream bis = new BufferedInputStream(body.byteStream(), 1024 * 8);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                image.setImageBitmap(bitmap);
                // Log.d("Persons:" ,persons.get(1).navn);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Foods:", t.getMessage().toString());
            }
        });


        return v;

    }

}
