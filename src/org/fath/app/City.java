package org.fath.app;

import java.util.ArrayList;
import java.util.List;

public class City {

    private int id;
    private boolean isUnited;
    private List<City> relatedCityList = new ArrayList<>();

    public City(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUnited() {
        return isUnited;
    }

    public void setUnited(boolean united) {
        isUnited = united;
    }

    public List<City> getRelatedCityList() {
        return relatedCityList;
    }

    public void setRelatedCityList(List<City> relatedCityList) {
        this.relatedCityList = relatedCityList;
    }

}
