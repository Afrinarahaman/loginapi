package com.example.newapp;

import android.graphics.Bitmap;

import com.example.newapp.apiInterface;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface apiInterface {

    //@FormUrlEncoded
    //@Headers("Content-Type:application/json")
    @POST("login")
    Call<PersonResponse> login(@Body LoginRequest request);

    @POST("register")
    Call <PersonResponse>registerPerson(@Body PersonModel person);

    @GET("foods")
    Call<List<FoodModel>> getAllFoods();

    @GET("{fullUrl}}")
    Call<ResponseBody> GetImage(@Path(value = "fullUrl", encoded = true) String fullUrl);
}
