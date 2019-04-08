package com.example.kaka.myweather.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.applocation.Mylocation;
import com.example.kaka.myweather.bean.CityBean;
import com.example.kaka.myweather.bean.DistrictBean;
import com.example.kaka.myweather.bean.MsgBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.ViewHolder> {
    private List<DistrictBean> mDistrictList;
    private CityCallBack mCityCallBack;
    public DistrictAdapter(List<DistrictBean> districtList) {
        mDistrictList = districtList;
    }

    public interface CityCallBack{
        void city_Ok();
    }

    public void setmCityCallBack(CityCallBack mCityCallBack) {
        this.mCityCallBack = mCityCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Mylocation.getContext()).inflate(R.layout.item_district,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DistrictBean districtBean = mDistrictList.get(holder.getAdapterPosition());
                EventBus.getDefault().post(new DistrictBean(districtBean.getName(),districtBean.getWeather_id()));
                mCityCallBack.city_Ok();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DistrictBean districtBean = mDistrictList.get(i);
        viewHolder.districtName.setText(districtBean.getName());
    }

    @Override
    public int getItemCount() {
        return mDistrictList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView districtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            districtName = itemView.findViewById(R.id.districtName);
        }
    }
}
