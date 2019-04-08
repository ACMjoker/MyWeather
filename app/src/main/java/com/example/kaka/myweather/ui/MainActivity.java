package com.example.kaka.myweather.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.applocation.Mylocation;
import com.example.kaka.myweather.bean.DistrictBean;
import com.example.kaka.myweather.config.MyConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cityGo)
    ImageView cityGo;
    @BindView(R.id.myCity)
    TextView myCity;
    private DistrictBean myDistrictBean = new DistrictBean();
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMySaveCity();
        EventBus.getDefault().register(this);
    }

    private void getMySaveCity() {
        preferences = PreferenceManager.getDefaultSharedPreferences(Mylocation.getContext());
        String weatherId = preferences.getString(MyConfig.WEATHER_ID, null);
        String cityName = preferences.getString(MyConfig.CITY_NAME, null);
        myCity.setText(cityName);
        myDistrictBean.setName(cityName);
        myDistrictBean.setWeather_id(weatherId);
    }

    @OnClick({R.id.myCity, R.id.cityGo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myCity:
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intent);
                break;
            case R.id.cityGo:
                if(!TextUtils.isEmpty(myDistrictBean.getName())&&!TextUtils.isEmpty(myDistrictBean.getWeather_id())){
                    Intent intent1 = new Intent(MainActivity.this, WeatherActivity.class);
                    intent1.putExtra(MyConfig.MYDISTRICT,myDistrictBean);
                    startActivity(intent1);
                }else {
                    Toast.makeText(this, "请选择您的城市", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Subscribe
    public void Event(DistrictBean districtBean) {
        if (!TextUtils.isEmpty(districtBean.getName())) {
//            Toast.makeText(this, districtBean.getName(), Toast.LENGTH_SHORT).show();
            myDistrictBean = districtBean;
            myCity.setText(districtBean.getName());
            saveMyCity(districtBean);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void saveMyCity(DistrictBean myDistrictBean){
        if(myDistrictBean!=null){
            editor = preferences.edit();
            editor.putString(MyConfig.WEATHER_ID,myDistrictBean.getWeather_id());
            editor.putString(MyConfig.CITY_NAME,myDistrictBean.getName());
            editor.commit();
        }
    }
}
