package vox.com.retrofit.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielMartin on 28/01/2018.
 */


public class City {

    private int id;//-----
    private String name;//------
    private String country;//-----
    private String[] icon;
    private String[] temp;
    private String[] tempMax;
    private String[] tempMin;
    private String[] description;


    public City(int id, String name, String country, String[] icon, String[] temp, String[] tempMax, String[] tempMin, String[] description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.icon = icon;
        this.temp = temp;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.description = description;
    }

    public String[] getTempMax() {
        return tempMax;
    }

    public void setTempMax(String[] tempMax) {
        this.tempMax = tempMax;
    }

    public String[] getTempMin() {
        return tempMin;
    }

    public void setTempMin(String[] tempMin) {
        this.tempMin = tempMin;
    }

    public String[] getTemp() {
        return temp;
    }

    public void setTemp(String[] temp) {
        this.temp = temp;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getIcon() {
        return icon;
    }

    public void setIcon(String[] icon) {
        this.icon = icon;
    }



}
