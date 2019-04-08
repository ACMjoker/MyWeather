package com.example.kaka.myweather.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.fragment.CityFragment;
import com.example.kaka.myweather.fragment.DistrictFragment;
import com.example.kaka.myweather.fragment.ProvinceFragment;
import com.example.kaka.myweather.gson.GsonWork;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityActivity extends AppCompatActivity {
    @BindView(R.id.cityToolbar)
    Toolbar cityToolbar;
    @BindView(R.id.PFragment)
    FrameLayout PFragment;
    @BindView(R.id.CFragment)
    FrameLayout CFragment;
    @BindView(R.id.DFragment)
    FrameLayout DFragment;
    private ProvinceFragment provinceFragment = new ProvinceFragment();
    private CityFragment cityFragment = new CityFragment();
    private DistrictFragment districtFragment = new DistrictFragment();
    GsonWork mGsonWork = new GsonWork();
    int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ButterKnife.bind(this);
        Toolbarinit();
        Fragmentinit();
    }

    private void Toolbarinit() {
        
    }

    private void Fragmentinit() {
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.PFragment,provinceFragment)
                .show(provinceFragment)
                .commit();
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.CFragment,cityFragment)
                .show(cityFragment)
                .commit();
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.DFragment,districtFragment)
                .show(districtFragment)
                .commit();
    }
}
