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
    private int size;
    private HashSet<Athlete> players;
    private Date date;
    private Marker loc;
    Location location;

    public Game(int numplayers, Date date, Location location) {
        this.numplayers = numplayers;
        players = new HashSet<>();
        this.location = location;
        this.date =  date;
    }

    public boolean addPlayer(Athlete next) {
        if (isFull()) {
            return false;
        }
        if (players.add(next)) {
                size++;
                return true;
        }
        return false;
    }

    public boolean isFull() {
        return size == numplayers;
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

    public int getSize(){
        return size;
    }

    public int getNumplayers() {
        return numplayers;
    }

    public boolean equals(Game game) {
        if (this.date.equals(game.getDate()) && this.location.equals(game.getLocation())) {
            return true;
        }
        return false;
    }
}
