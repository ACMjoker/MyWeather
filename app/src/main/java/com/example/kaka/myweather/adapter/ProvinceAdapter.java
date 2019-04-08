package com.example.kaka.myweather.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaka.myweather.R;
import com.example.kaka.myweather.applocation.Mylocation;
import com.example.kaka.myweather.bean.MsgBean;
import com.example.kaka.myweather.bean.ProvinceBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {
    private List<ProvinceBean> mProvinceList;
    public ProvinceAdapter(List<ProvinceBean> provinceList) {
        mProvinceList = provinceList;
    }
//    private onClientCallBack mOnClientCallBack;
//
//    public void setmOnClientCallBack(onClientCallBack onClientCallBack) {
//        mOnClientCallBack = onClientCallBack;
//    }
//
//    public interface onClientCallBack{
//        void sendMsg(MsgBean msgBean);
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Mylocation.getContext()).inflate(R.layout.item_province,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProvinceBean provinceBean = mProvinceList.get(holder.getAdapterPosition());
                EventBus.getDefault().post(new MsgBean(1,provinceBean.getId()));
//                mOnClientCallBack.sendMsg(new MsgBean(1,provinceBean.getId()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ProvinceBean provinceBean = mProvinceList.get(i);
        viewHolder.provinceName.setText(provinceBean.getName());
    }

    @Override
    public int getItemCount() {
        return mProvinceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView provinceName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            provinceName = itemView.findViewById(R.id.provinceName);
        }
    }
}
