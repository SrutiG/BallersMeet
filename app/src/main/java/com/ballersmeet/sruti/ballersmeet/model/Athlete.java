package com.ballersmeet.sruti.ballersmeet.model;

import java.io.Serializable;

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
}
