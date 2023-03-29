package com.example.newapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

class RetrieveFeedTask extends AsyncTask<String, Void, Bitmap> {

    private Exception exception;

    protected Bitmap doInBackground(String... urls) {

        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL("https://w7.pngwing.com/pngs/739/553/png-transparent-hamburger-veggie-burger-chicken-sandwich-fast-food-hamburger-burger-burger-sandwich-food-recipe-cheeseburger-thumbnail.png").getContent());
            return bitmap;
        }
        catch (Exception e) {
            Log.e("MyTag", "Failure to download and display image from url.", e);
            exception = e;
        }
        return null;
    }


}
