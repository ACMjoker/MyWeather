package com.example.kaka.myweather.db;

import android.util.Log;

import com.example.kaka.myweather.applocation.Mylocation;
import com.example.kaka.myweather.bean.CityBean;
import com.example.kaka.myweather.bean.DistrictBean;
import com.example.kaka.myweather.bean.ProvinceBean;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class DBWork {
    private DBHelp getDBHelp(){
        return DBHelp.getInstance(Mylocation.getContext());
    }

    private Dao<ProvinceBean,Integer> ProvinceDao() throws SQLException {
        return getDBHelp().getDao(ProvinceBean.class);
    }

    private Dao<CityBean,Integer> CityDao() throws SQLException {
        return getDBHelp().getDao(CityBean.class);
    }

    private Dao<DistrictBean,Integer> DistrictDao() throws SQLException {
        return getDBHelp().getDao(DistrictBean.class);
    }

    public void InsertProvince(final List<ProvinceBean> provinceList) throws SQLException {
        final Dao<ProvinceBean, Integer> provinceDao = ProvinceDao();
        try {
            provinceDao.callBatchTasks(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    for (ProvinceBean bean:provinceList) {
                        provinceDao.createOrUpdate(bean);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertCity(final List<CityBean> list) throws SQLException {
        final Dao<CityBean, Integer> cityDao = CityDao();
        try {
            cityDao.callBatchTasks(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    for (CityBean bean:list) {
                        cityDao.createOrUpdate(bean);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertDistrict(final List<DistrictBean> list) throws SQLException {
        final Dao<DistrictBean, Integer> districtBeans = DistrictDao();
        try {
            districtBeans.callBatchTasks(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    for (DistrictBean bean:list) {
                        districtBeans.createOrUpdate(bean);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProvinceBean> QueryAllProvince(){
        List<ProvinceBean> bean = new ArrayList<>();
        try {
            Dao<ProvinceBean, Integer> provinceDao = ProvinceDao();
            bean = provinceDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public List<CityBean> QueryCityFor_Id(int _id){
        List<CityBean> bean = new ArrayList<>();
        try {
            Dao<CityBean, Integer> cityDao = CityDao();
            Where<CityBean, Integer> id = cityDao.queryBuilder().where().eq("_id", _id);
            bean = id.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public List<DistrictBean> QueryDistrictFor_Id(int _id){
        List<DistrictBean> bean = new ArrayList<>();
        try {
            Dao<DistrictBean, Integer> districtDao = DistrictDao();
            Where<DistrictBean, Integer> weather_id = districtDao.queryBuilder().where().eq("_id", _id);
            bean = weather_id.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
