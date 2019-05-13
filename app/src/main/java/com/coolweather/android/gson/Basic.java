package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 24395 on 2019/5/12.
 */

/*
基本信息
 */
public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
    public Update update;
}
