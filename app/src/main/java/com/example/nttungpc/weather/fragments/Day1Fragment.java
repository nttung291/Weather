package com.example.nttungpc.weather.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nttungpc.weather.R;
import com.example.nttungpc.weather.adapter.WeatherAdapter;
import com.example.nttungpc.weather.cityweatherJSON.City;
import com.example.nttungpc.weather.cityweatherJSON.CityWeather;
import com.example.nttungpc.weather.cityweatherJSON.ListWeather;
import com.example.nttungpc.weather.cityweatherJSON.Weather;
import com.example.nttungpc.weather.retrofit.RetrofitFactory;
import com.example.nttungpc.weather.retrofit.WeatherService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.nttungpc.weather.MainActivity.cityName;


/**
 * A simple {@link Fragment} subclass.
 */
public class Day1Fragment extends Fragment{
    private static final String TAG = "";
    private RecyclerView rvDay1;
    private static CityWeather cityWeather = new CityWeather();
    private WeatherAdapter weatherAdapter;



    public Day1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day1, container, false);
        // Inflate the layout for this fragment
        loadData(view);
//        setUI(view);
        return view;
    }



    private void setUI(View view) {

    }

    public void loadData(final View view) {
        if (cityName != null){
            WeatherService weatherService = RetrofitFactory.getInstance()
                    .create(WeatherService.class);
            final Context context = getContext();
            weatherService.getCityWeather(cityName,"metric","dc491cbe9649e90d5cb12ec67fcdbc01").enqueue(new Callback<CityWeather>() {
                @Override
                public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                    if (cityWeather!=null){
                        cityWeather = response.body();
//                        weatherAdapter.notifyDataSetChanged();
                        rvDay1 = view.findViewById(R.id.rv_weather);
                        weatherAdapter = new WeatherAdapter(cityWeather.getList(),getContext());
                        rvDay1.setAdapter(weatherAdapter);
                    }
                }
                @Override
                public void onFailure(Call<CityWeather> call, Throwable t) {
                    Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
