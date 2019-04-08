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
import com.example.kaka.myweather.adapter.ProvinceAdapter;
import com.example.kaka.myweather.bean.MsgBean;
import com.example.kaka.myweather.bean.ProvinceBean;
import com.example.kaka.myweather.config.MyConfig;
import com.example.kaka.myweather.db.DBWork;
import com.example.kaka.myweather.gson.GsonWork;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.sql.SQLException;
import java.util.List;

public class ProvinceFragment extends Fragment {
    private RecyclerView provinceRecycler;
    private GsonWork mGsonWork = new GsonWork();
    private DBWork dbWork = new DBWork();;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_province,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<ProvinceBean> provinceBeans = dbWork.QueryAllProvince();
        if(provinceBeans.size()==0){
            Log.d("asd","Province INTENET");
            getAllProvince();
        }else {
            Log.d("asd","Province SQL");
            setRecyclerView(provinceBeans);
        }
    }

    private void getAllProvince() {
        OkGo.<String>get(MyConfig.provinceURI)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<ProvinceBean> provinceBeans = mGsonWork.jsonProvince(response.body());
                        setRecyclerView(provinceBeans);
                        try {
                            dbWork.InsertProvince(provinceBeans);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Logger.d("eee");
                    }
                });
    }

    public void setRecyclerView(List<ProvinceBean> provinceList){
        provinceRecycler = getView().findViewById(R.id.provinceRecycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        provinceRecycler.setLayoutManager(manager);
        ProvinceAdapter adapter = new ProvinceAdapter(provinceList);
        provinceRecycler.setAdapter(adapter);
    }
}
