package com.example.kaka.myweather.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.adapter.CityAdapter;
import com.example.kaka.myweather.bean.CityBean;
import com.example.kaka.myweather.bean.MsgBean;
import com.example.kaka.myweather.config.MyConfig;
import com.example.kaka.myweather.db.DBWork;
import com.example.kaka.myweather.gson.GsonWork;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityFragment extends Fragment {
    private RecyclerView cityRecycler;
    private GsonWork mGsonWork = new GsonWork();
    private DBWork dbWork = new DBWork();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

   @Subscribe
   public void onEvent(MsgBean msgBean){
       MyConfig.districtURI = MyConfig.districtURI+msgBean.getMsgId();
       if(msgBean.getId() == 1){
           List<CityBean> cityBeans = dbWork.QueryCityFor_Id(msgBean.getMsgId());
           if(cityBeans.size()==0) {
               Log.d("asd", "City INTENET");
               getCity(msgBean.getMsgId());
           }else {
               Log.d("asd","City SQL");
               setCityRecyclerView(cityBeans);
           }
       }
   }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void getCity(final int provinceId){
        OkGo.<String>get(MyConfig.cityURI+provinceId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<CityBean> jsoncity = mGsonWork.jsonCity(response.body());
                        List<CityBean> cityList = new ArrayList<>();
                        for (CityBean bean:jsoncity) {
                            bean.setMainId(provinceId+"_"+bean.getId());
                            bean.set_id(provinceId);
                            cityList.add(bean);
                        }
                        setCityRecyclerView(jsoncity);
                        try {
                            dbWork.InsertCity(cityList);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void setCityRecyclerView(List<CityBean> cityList){
        cityRecycler = getView().findViewById(R.id.cityRecycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        cityRecycler.setLayoutManager(manager);
        CityAdapter adapter = new CityAdapter(cityList);
        cityRecycler.setAdapter(adapter);
    }
}
