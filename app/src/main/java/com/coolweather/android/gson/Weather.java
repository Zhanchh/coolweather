package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 24395 on 2019/5/12.
 */
/*
总的实例来以用各个实体例，这个才是GSON数据对应的实体类
 */
public class Weather {
    public String status;

    public AQI aqi;

    public Basic basic;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
