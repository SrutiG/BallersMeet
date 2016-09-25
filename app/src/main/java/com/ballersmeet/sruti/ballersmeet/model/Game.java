package com.ballersmeet.sruti.ballersmeet.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anna on 9/24/2016.
 */
public class Game implements Serializable{
    private int numplayers;
    private int size;
    private Athlete[] players;
    private Date date;
    private Location location;

    public Game(int numplayers, Date date, Location location) {
        this.numplayers = numplayers;
        players = new Athlete[numplayers];
        this.location = location;
        this.date =  date;
    }

    public String addPlayer(Athlete next) {
        if (size == players.length) {
            return("Game is full");
        } else {
            players[size] = next;
            size++;
            return ("Player added!");
        }
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

    public Location getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
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
}
