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
import com.example.kaka.myweather.adapter.DistrictAdapter;
import com.example.kaka.myweather.bean.DistrictBean;
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

public class DistrictFragment extends Fragment {
    private RecyclerView districtRecycler;
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
        return inflater.inflate(R.layout.fragment_district,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Subscribe
    public void Event(MsgBean msgBean){
        switch (msgBean.getId()){
            case 1:
                if(districtRecycler!=null){
                    List<DistrictBean> districtList = new ArrayList<>();
                    setDistrictRecyclerView(districtList);
                }
                break;
            case 2:
                List<DistrictBean> districtBeans = dbWork.QueryDistrictFor_Id(msgBean.getMsgId());
                if(districtBeans.size()==0){
                    Log.d("asd","District INTENET");
                    getAllDistrict(msgBean.getMsgId());
                }else {
                    Log.d("asd","District SQL");
                    setDistrictRecyclerView(districtBeans);
                }
                break;
        }
    }

    public void getAllDistrict(final int districtId){
        OkGo.<String>get(MyConfig.districtURI+"/"+districtId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<DistrictBean> districtBeans = mGsonWork.jsonDistrict(response.body());
                        List<DistrictBean> districtList = new ArrayList<>();
                        for (DistrictBean bean:districtBeans) {
                            bean.set_id(districtId);
                            bean.setMainId(districtId+"_"+bean.getId());
                            districtList.add(bean);
                        }
                        setDistrictRecyclerView(districtList);
                        try {
                            dbWork.InsertDistrict(districtList);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void setDistrictRecyclerView(List<DistrictBean> districtList){
        districtRecycler = getView().findViewById(R.id.districtRecycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        districtRecycler.setLayoutManager(manager);
        DistrictAdapter adapter = new DistrictAdapter(districtList);
        adapter.setmCityCallBack(new DistrictAdapter.CityCallBack() {
            @Override
            public void city_Ok() {
                getActivity().finish();
            }
        });
        districtRecycler.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
