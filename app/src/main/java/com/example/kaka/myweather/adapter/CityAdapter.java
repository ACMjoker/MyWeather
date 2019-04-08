package com.example.kaka.myweather.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.applocation.Mylocation;
import com.example.kaka.myweather.bean.CityBean;
import com.example.kaka.myweather.bean.MsgBean;
import com.example.kaka.myweather.bean.ProvinceBean;
import com.example.kaka.myweather.config.MyConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private List<CityBean> mCityList;
    public CityAdapter(List<CityBean> cityList) {
        mCityList = cityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Mylocation.getContext()).inflate(R.layout.item_city,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityBean cityBean = mCityList.get(holder.getAdapterPosition());
                EventBus.getDefault().post(new MsgBean(2,cityBean.getId()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CityBean cityBean = mCityList.get(i);
        viewHolder.cityName.setText(cityBean.getName());
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView cityName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            cityName = itemView.findViewById(R.id.cityName);
        }
    }
}
