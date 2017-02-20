package com.example.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyj on 2017/2/20.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public  More more;


    private class More {
        @SerializedName("txt")
        public String info;
    }
}
