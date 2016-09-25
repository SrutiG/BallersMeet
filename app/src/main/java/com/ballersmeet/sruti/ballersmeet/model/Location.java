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

    public Location(String name) {
        this(name, null, 0, null, null);
    }

    public Location(String name, String address, int zip, String city, String state) {
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.state = state;
    }

    public String toString() {
        return name;
    }
}
