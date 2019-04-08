package com.example.kaka.myweather.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Province")
public class ProvinceBean {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private String name;

    public ProvinceBean() {
    }

    public ProvinceBean(int id, String name) {
        this.id = id;
        this.name = name;
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
