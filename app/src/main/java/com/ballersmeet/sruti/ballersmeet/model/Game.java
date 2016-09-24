package com.ballersmeet.sruti.ballersmeet.model;

import java.util.Date;

/**
 * Created by Anna on 9/24/2016.
 */
public class Game {
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

}
