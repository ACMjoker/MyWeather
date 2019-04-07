package com.example.kaka.myweather.bean;

public class ProvinceBean {
    private int id;
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
