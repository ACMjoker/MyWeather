package com.example.kaka.myweather.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "District")
public class DistrictBean implements Serializable {
    @DatabaseField(id = true)
    private String mainId;
    @DatabaseField(canBeNull = false)
    private int _id;
    @DatabaseField(canBeNull = false)
    private int id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private String weather_id;

    public DistrictBean() {
    }

    public DistrictBean(String name, String weather_id) {
        this.name = name;
        this.weather_id = weather_id;
    }

    public DistrictBean(int id, String name, String weather_id) {
        this.id = id;
        this.name = name;
        this.weather_id = weather_id;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }
}
