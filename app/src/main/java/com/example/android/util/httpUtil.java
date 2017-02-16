package com.example.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by tyj on 2017/2/16.
 */

public class httpUtil {

    public static  void sendOkhttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
         client.newCall(request).enqueue(callback);
    }
}
