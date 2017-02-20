package com.example.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyj on 2017/2/20.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;

    }


}
