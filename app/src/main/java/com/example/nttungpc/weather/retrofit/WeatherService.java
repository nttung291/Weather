package com.example.nttungpc.weather.retrofit;

import com.example.nttungpc.weather.cityweatherJSON.CityWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nttung PC on 10/14/2017.
 */

public interface WeatherService {
    @GET("data/2.5/forecast")
    Call<CityWeather> getCityWeather(@Query("q") String order,@Query("units") String metric, @Query("APPID") String key);
}
