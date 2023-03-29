package com.example.newapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface apiImageInterface {

    @GET
    public Call<ResponseBody> GetImage(@Url String url);
}