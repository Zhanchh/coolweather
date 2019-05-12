package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 24395 on 2019/5/11.
 */

public class Utility {
    //解析和处理服务器返回的省级信息
    public static boolean handleProvinceResponse(String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            try {
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++ )
                {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);//获取到的每一个元素都是JSONObject对象。
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                    //Province,City,County都是Litepal数据库定义的表格类，所以把获取到的服务器数据进行解析后
                    //通过set方法传入数据库，并通过save保存。所以整个服务器在设计的时候里面的信息也指定和数据库是相对应的
                    //比如数据库中有Name，那么服务器中也指定有Name。
                }
                return true;

            }catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    //解析和处理服务器返回的市级信息
    public static boolean handleCityResponse(String response,int provinceId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++)
                {
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    //解析和处理服务器返回的县级数据
    public static boolean handleCountyResponse(String response,int cityId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allCounties=new JSONArray(response);
                for(int i=0;i<allCounties.length();i++)
                {
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
