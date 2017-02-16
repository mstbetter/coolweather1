package com.example.android.util;

import android.text.TextUtils;

import com.example.android.db.City;
import com.example.android.db.County;
import com.example.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tyj on 2017/2/16.
 */

public class Utility {
    public static boolean handleProvinceReponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {

                    JSONObject allProvincesJSONObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(allProvincesJSONObject.getString("name"));
                    province.setProvinceCode(allProvincesJSONObject.getInt("id"));
                    province.save();

                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return false;
    }


    public static boolean handleCityResponse(String response, int provinceId) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {

                    JSONObject allCitiesJSONObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(allCitiesJSONObject.getString("name"));
                    city.setCityCode(allCitiesJSONObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();


                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    public static boolean handleCountyResponse(String response, int cityId) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounty = new JSONArray(response);
                for (int i = 0; i < allCounty.length(); i++) {

                    JSONObject allCountyJSONObject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(allCountyJSONObject.getString("name"));
                    county.setWeatherId(allCountyJSONObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();


                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }



}
