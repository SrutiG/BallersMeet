package com.ballersmeet.sruti.ballersmeet.model;


import com.google.android.gms.maps.model.Marker;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Anna on 9/24/2016.
 */
public class Game implements Serializable{
    private int numplayers;
    private int capacity;
    private HashSet<Athlete> players;
    private Date date;
    private Marker loc;
    private Location location;

    public Game(int capacity, Date date, Location location) {
        this.capacity = capacity;
        players = new HashSet<>();
        this.location = location;
        this.date =  date;
    }

    public boolean addPlayer(Athlete next) {
        if (isFull()) {
            return false;
        }
        if (players.add(next)) {
                numplayers++;
                return true;
        }
        return false;
    }

    public boolean isFull() {
        return capacity == numplayers;
    }

    public void setGameTime(int hour, int minute) {
        date.setMinutes(minute);
        date.setHours(hour);
    }

    public void setGameDate(int day, int month, int year) {
        date.setDate(day);
        date.setMonth(month);
        date.setYear(year);
    }

    public Date getDate() {
        return date;
    }

    public Location getLocation() {
        return location;
    }

    public String getDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formatDate = sdf.format(date);
        String day = formatDate.substring(5,10);
        return day;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formatDate = sdf.format(date);
        String time = formatDate.substring(11);
        return time;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNumplayers() {
        return numplayers;
    }

}
