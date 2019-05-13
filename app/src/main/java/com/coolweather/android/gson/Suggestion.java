package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 24395 on 2019/5/12.
 */
/*
关于天气的一些建议
 */
public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;
    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
