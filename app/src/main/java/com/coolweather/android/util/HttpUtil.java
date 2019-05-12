package com.coolweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 24395 on 2019/5/11.
 */
//sendOkHttpRequest方法用于向服务器发送请求
public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                                    .url(address)
                                    .build();
        client.newCall(request).enqueue(callback);
    }
}
