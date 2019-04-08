package com.example.kaka.myweather.gson;

import com.example.kaka.myweather.bean.CityBean;
import com.example.kaka.myweather.bean.DistrictBean;
import com.example.kaka.myweather.bean.ProvinceBean;
import com.example.kaka.myweather.bean.WeatherBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import java.util.List;

public class GsonWork {
    private Gson mGson = null;
    public GsonWork() {
        Gson gson = new Gson();
        mGson = gson;
    }

    public List<ProvinceBean> jsonProvince(String provinceJson){
        List<ProvinceBean> provinceBean = mGson.fromJson(provinceJson, new TypeToken<List<ProvinceBean>>(){}.getType());
        Logger.d(provinceBean);
        return  provinceBean;
    }

    public List<CityBean> jsonCity(String cityJson){
        List<CityBean> cityBeans = mGson.fromJson(cityJson, new TypeToken<List<CityBean>>(){}.getType());
        Logger.d(cityBeans);
        return  cityBeans;
    }

    public List<DistrictBean> jsonDistrict(String districtJson){
        List<DistrictBean> districtBeans = mGson.fromJson(districtJson, new TypeToken<List<DistrictBean>>(){}.getType());
        Logger.d(districtBeans);
        return  districtBeans;
    }
    public WeatherBean jsonWeather(String weatherJson){
        WeatherBean weatherBean = mGson.fromJson(weatherJson, WeatherBean.class);
        Logger.d(weatherBean);
        return weatherBean;
    }
}
