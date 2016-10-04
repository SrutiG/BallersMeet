package com.ballersmeet.sruti.ballersmeet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Sruti on 9/24/16.
 */
public class Athlete implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private int level;
    private String username;
    private String password;
    private ArrayList<Game> gameQueue;

    public Athlete(String firstname, String lastname, String email, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Athlete (String username, String password) {
        this(null, null, null, username, password);
    }

    public void setLevel(int level) {
        if (level >= 1 && level <= 10) {
            this.level = level;
        }
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Game> getGames() {
        return gameQueue;
    }

    public void addGameQueue(Game game) {
        if (gameQueue == null) {
            gameQueue = new ArrayList<Game>();
        }
        gameQueue.add(game);
    }
}
