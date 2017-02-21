package com.example.android.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;

import com.example.android.gson.Weather;
import com.example.android.util.Utility;

public class AutoUpdateService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        updateWeather();


        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 更新天气信息
     */
    private void updateWeather() {

        SharedPreferences pres =
                PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = pres.getString("weather", null);
        if (weatherString !=null){
              //有缓存时直接解析数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            String weatherId = weather.basic.weatherId;

            String weatherUrl="http://guolin.tech/api/weather?cityId="+weatherId+"&key=bc0418b57b2d4918819d3974ac1285d9";

            
        }

    }
}
