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
import com.example.kaka.myweather.bean.WeatherBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class Daily_ForecastAdapter extends RecyclerView.Adapter<Daily_ForecastAdapter.ViewHolder> {
    private List<WeatherBean.HeWeather.Daily_forecast> mList;
    public Daily_ForecastAdapter(List<WeatherBean.HeWeather.Daily_forecast> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Mylocation.getContext()).inflate(R.layout.item_daily_forecast,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherBean.HeWeather.Daily_forecast daily_forecast = mList.get(holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WeatherBean.HeWeather.Daily_forecast daily_forecast = mList.get(i);
        viewHolder.item_time.setText(daily_forecast.getDate());
        viewHolder.item_txt_d.setText(daily_forecast.getCond().getTxt_d());
        viewHolder.item_min.setText(daily_forecast.getTmp().getMin());
        viewHolder.item_max.setText(daily_forecast.getTmp().getMax());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView item_time;
        private TextView item_txt_d;
        private TextView item_max;
        private TextView item_min;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            item_time = itemView.findViewById(R.id.item_time);
            item_txt_d = itemView.findViewById(R.id.item_txt_d);
            item_max = itemView.findViewById(R.id.item_max);
            item_min = itemView.findViewById(R.id.item_min);
        }
    }
}
