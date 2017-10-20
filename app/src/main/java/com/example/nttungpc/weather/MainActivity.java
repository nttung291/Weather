package com.example.nttungpc.weather;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nttungpc.weather.adapter.ViewPagerAdapter;
import com.example.nttungpc.weather.adapter.WeatherAdapter;
import com.example.nttungpc.weather.cityweatherJSON.CityWeather;
import com.example.nttungpc.weather.cityweatherJSON.ListWeather;
import com.example.nttungpc.weather.fragments.Day1Fragment;
import com.example.nttungpc.weather.retrofit.RetrofitFactory;
import com.example.nttungpc.weather.retrofit.WeatherService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button show;
    public static String cityName;
    private EditText etCityname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.bt_show);
        etCityname = (EditText) findViewById(R.id.et_cityname);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName = etCityname.getText().toString();
                setUI();
            }
        });
    }
    private void setUI() {
        tabLayout = (TabLayout) findViewById(R.id.tl_city);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search_black_24dp));
        tabLayout.getTabAt(0).getIcon().setAlpha(0);
        tabLayout.getTabAt(1).getIcon().setAlpha(0);
        tabLayout.getTabAt(2).getIcon().setAlpha(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // An 2 lan lien tuc vao tab
            }
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }



}
