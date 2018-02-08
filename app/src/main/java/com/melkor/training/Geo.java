package com.melkor.training;

/**
 * Created by franco.salvatierra on 08/02/2018.
 */

public class Geo {

    private String lat;
    private String lng;

    public Geo(String Lat, String Lng)
    {
        this.lat = Lat;
        this.lng = Lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
