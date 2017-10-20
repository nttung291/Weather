package com.example.nttungpc.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nttungpc.weather.R;
import com.example.nttungpc.weather.cityweatherJSON.ListWeather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Nttung PC on 10/19/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<ListWeather> listWeathers;
    private Context context;

    public WeatherAdapter(List<ListWeather> listWeather, Context context) {
        this.listWeathers = listWeather;
        this.context = context;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.item_cityweather,parent,false);
        Log.d("AAAA", "setData: " + listWeathers.size());
        return new WeatherViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.setData(listWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return listWeathers.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{
        TextView tvTemp;
        TextView tvDate;
        TextView tvHour;
        TextView tvMain;
        TextView tvHumidity;
        TextView tvPressure;
        Date date;
        String dateout;
        String hoursout;
        View view;
        public WeatherViewHolder(View itemView) {
            super(itemView);
            tvTemp = itemView.findViewById(R.id.tv_temp);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvHour = itemView.findViewById(R.id.tv_hours);
            tvMain = itemView.findViewById(R.id.tv_main);
            tvHumidity = itemView.findViewById(R.id.tv_humidity);
            tvPressure = itemView.findViewById(R.id.tv_pressure);
            view = itemView;
        }

        public void setData(final ListWeather listWeather){
            Log.d("AAA", "setData: " + listWeathers.size());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = format.parse(listWeather.getDtTxt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat dateinput =  new SimpleDateFormat("E,dd MMM yyyy");
            dateout = dateinput.format(date);
            SimpleDateFormat hoursinput =  new SimpleDateFormat("HH:mm");
            hoursout = hoursinput.format(date);
            tvTemp.setText(Double.toString(listWeather.getMain().getTemp()) + "°C");
            tvMain.setText(listWeather.getWeather().get(0).getDescription().toUpperCase());
            tvHumidity.setText(Integer.toString(listWeather.getMain().getHumidity()) + "%");
            tvPressure.setText(Double.toString(listWeather.getMain().getPressure()));
            tvDate.setText(dateout);
            tvHour.setText(hoursout);
        }
    }
}
