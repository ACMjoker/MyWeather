package com.example.kaka.myweather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.adapter.Daily_ForecastAdapter;
import com.example.kaka.myweather.bean.DistrictBean;
import com.example.kaka.myweather.bean.WeatherBean;
import com.example.kaka.myweather.config.MyConfig;
import com.example.kaka.myweather.gson.GsonWork;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {
    @BindView(R.id.weather_CityName)
    TextView weatherCityName;
    @BindView(R.id.weather_tmp)
    TextView weatherTmp;
    @BindView(R.id.weather_cond_txt)
    TextView weatherCondTxt;
    @BindView(R.id.daily_forecast)
    RecyclerView dailyForecast;
    @BindView(R.id.aqi)
    TextView aqi;
    @BindView(R.id.pm)
    TextView pm;
    @BindView(R.id.comf)
    TextView comf;
    @BindView(R.id.sport)
    TextView sport;
    @BindView(R.id.cw)
    TextView cw;
    private GsonWork mGsonWork = new GsonWork();
    private DistrictBean bean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        getMyDistrict();
        getWeather();
    }

    private void getMyDistrict() {
        Intent intent = getIntent();
        bean = (DistrictBean) intent.getSerializableExtra(MyConfig.MYDISTRICT);
        if (bean != null) {
            Toast.makeText(this, bean.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    public void getWeather() {
        OkGo.<String>get(MyConfig.weatherURI + "=" + bean.getWeather_id() + "&key=" + "745980b241b9438b9c041bc214e05e47")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WeatherBean weatherBean = mGsonWork.jsonWeather(response.body());
                        Logger.d(weatherBean);
                        setDate(weatherBean);

                    }
                });
    }

    public void setDate(WeatherBean weatherBean) {
        weatherCityName.setText(weatherBean.getHeWeather().get(0).getBasic().getLocation());
        weatherTmp.setText(weatherBean.getHeWeather().get(0).getNow().getTmp() + "℃");
        weatherCondTxt.setText(weatherBean.getHeWeather().get(0).getNow().getCond_txt());
        List<WeatherBean.HeWeather.Daily_forecast> daily_forecast = weatherBean.getHeWeather().get(0).getDaily_forecast();
        setRecyclerView(daily_forecast);
        aqi.setText(weatherBean.getHeWeather().get(0).getAqi().getCity().getAqi());
        pm.setText(weatherBean.getHeWeather().get(0).getAqi().getCity().getPm25());
        comf.setText(weatherBean.getHeWeather().get(0).getSuggestion().getComf().getTxt());
        sport.setText(weatherBean.getHeWeather().get(0).getSuggestion().getSport().getTxt());
        cw.setText(weatherBean.getHeWeather().get(0).getSuggestion().getCw().getTxt());
    }

    private void setRecyclerView(List<WeatherBean.HeWeather.Daily_forecast> daily_forecast) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        dailyForecast.setLayoutManager(manager);
        Daily_ForecastAdapter adapter = new Daily_ForecastAdapter(daily_forecast);
        dailyForecast.setAdapter(adapter);
    }
}
