package com.mehul.appvilla.retrofitsampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.zappos.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ZappoService zappoService = retrofit.create(ZappoService.class);
        Call<Products> productsCall =zappoService.getProductItemInformation("nike","b743e26728e16b81da139182bb2094357c31d331");

        productsCall.enqueue(new Callback<Products>() {
          @Override
          public void onResponse(Call<Products> call, Response<Products> response) {
              Log.e("Response", response + "");
             Products products = response.body();
              Log.e("Products", products.toString());
          }
          @Override
          public void onFailure(Call<Products> call, Throwable t) {
              Log.e("Response Failure", "FFFF");
          }
      });
    }
}


