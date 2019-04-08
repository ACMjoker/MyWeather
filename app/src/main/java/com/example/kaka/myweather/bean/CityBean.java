package com.example.kaka.myweather.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "City")
public class CityBean {
    @DatabaseField(id = true)
    private String mainId;
    @DatabaseField(canBeNull = false)
    private int _id;
    @DatabaseField(canBeNull = false)
    private int id;
    @DatabaseField(canBeNull = false)
    private String name;

    public CityBean() {
    }

    public CityBean(int id, String name) {
        this.id = id;
        this.name = name;
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
}
