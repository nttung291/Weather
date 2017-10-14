package com.example.nttungpc.weather;

import com.example.nttungpc.weather.model.CityWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nttung PC on 10/14/2017.
 */

public interface WeatherService {
    @GET("data/2.5/weather")
    Call<CityWeather> getCityWeather(@Query("q") String order,@Query("APPID") String key);
}
