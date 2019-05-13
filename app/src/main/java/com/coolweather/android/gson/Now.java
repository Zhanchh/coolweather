package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 24395 on 2019/5/12.
 */

/*
当前的天气信息
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}
