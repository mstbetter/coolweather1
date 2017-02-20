package com.example.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyj on 2017/2/20.
 */

public class Forecast {
    public String data;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;

    private class Temperature {

        public String max;

        public String min;
    }


    private class More {
        @SerializedName("txt_d")
        public  String info;
    }
}
