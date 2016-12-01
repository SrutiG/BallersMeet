package com.ballersmeet.sruti.ballersmeet.model;

import java.io.Serializable;

/**
 * Created by Anna on 9/24/2016.
 */
public class Location implements Serializable {
    private String name;
    private String address;
    private int zip;
    private String city;
    private String state;
    private String latLong;

    public Location(String name, String latLong) {
        this(name, null, 0, null, null, latLong);
    }

    public Location(String name, String address, int zip, String city, String state, String latLong) {
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.state = state;
        this.latLong = latLong;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getLatLong() {
        return latLong;
    }
    
    public String toString() { return name; }
}
