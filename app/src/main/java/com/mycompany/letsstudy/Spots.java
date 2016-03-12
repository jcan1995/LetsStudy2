package com.mycompany.letsstudy;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by joshua on 3/11/2016.
 */
public class Spots {
    private LatLng coordinates;
    private String spotName;
    private String description;
    private int rate;

    public Spots(LatLng coordinates, String name, String description, int rating){
        this.coordinates = coordinates;
        spotName = name;
        this.description = description;
        rate = rating;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LatLng coordinates) {
        this.coordinates = coordinates;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}