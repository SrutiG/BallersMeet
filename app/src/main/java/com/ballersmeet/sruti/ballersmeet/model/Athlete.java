package com.ballersmeet.sruti.ballersmeet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


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
    private HashSet<Game> gamesSet;

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

    public String getEmail() { return email; }

    public int getLevel() {
        return level;
    }

    public HashSet<Game> getGames() {
        return gamesSet;
    }

    public boolean addGame(Game game) {
        if (gamesSet.add(game)) {
            return true;
        }
        return false;
    }

    public void setGames(HashSet<Game> games) {
        gamesSet = games;
        for (Game g: gamesSet) {
            g.addPlayer(this);
        }
    }

    public ArrayList<Game> toArray() {
        ArrayList<Game> gamesList = new ArrayList<>(gamesSet);
        return gamesList;
    }
 }
