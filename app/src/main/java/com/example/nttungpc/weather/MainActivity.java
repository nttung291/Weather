package com.example.nttungpc.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nttungpc.weather.model.CityWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private Button btShow;
    private TextView tvCountry;
    private TextView tvMain;
    private TextView tvDescription;
    private TextView tvTemp;
    private TextView tvPressure;
    public static String cityName;
    public static final String APPID = "9c3ab78c411781247eb0b124611b79a8";
    private String TAG = "AAA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_cityname);
        btShow = (Button) findViewById(R.id.bt_show);
        tvCountry = (TextView) findViewById(R.id.tv_country);
        tvMain = (TextView) findViewById(R.id.tv_main);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvTemp = (TextView) findViewById(R.id.tv_temp);
        tvPressure = (TextView) findViewById(R.id.tv_pressure);

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName = etName.getText().toString();
               if (cityName != null){
                   WeatherService weatherService = RetrofitFactory.getInstance().create(WeatherService.class);
                   weatherService.getCityWeather(cityName,APPID).enqueue(new Callback<CityWeather>() {
                       @Override
                       public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                          if (response.body() != null){
                              tvCountry.setText(response.body().getSys().getCountry());
                              tvMain.setText(response.body().getWeather().get(0).getMain());
                              tvDescription.setText(response.body().getWeather().get(0).getDescription());
                              tvTemp.setText(response.body().getMain().getTemp().toString());
                              tvPressure.setText(response.body().getMain().getPressure().toString());

                          }else{
                              Toast.makeText(MainActivity.this, "There is no country", Toast.LENGTH_SHORT).show();
                          }
                       }

                       @Override
                       public void onFailure(Call<CityWeather> call, Throwable t) {
                           Toast.makeText(MainActivity.this, "No Connection", Toast.LENGTH_SHORT).show();
                           Log.d(TAG, "onFailure: " + t.toString());
                       }
                   });
               }else{
                   Toast.makeText(MainActivity.this, "Select city", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}
