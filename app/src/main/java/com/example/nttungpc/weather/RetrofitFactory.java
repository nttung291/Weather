package com.example.nttungpc.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.nttungpc.weather.MainActivity.cityName;

/**
 * Created by Nttung PC on 10/12/2017.
 */

public class RetrofitFactory {
    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
