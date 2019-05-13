package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 24395 on 2019/5/12.
 */

/*
未来的天气信息
 */
public class Forecast {
    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{

        public String max;

        public String min;
    }

    public class More{

        @SerializedName("txt_d")
        public String info;
    }
}
