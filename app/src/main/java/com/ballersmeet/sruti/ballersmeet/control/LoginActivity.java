package com.ballersmeet.sruti.ballersmeet.control;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ballersmeet.sruti.ballersmeet.model.Athlete;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Game;
import com.ballersmeet.sruti.ballersmeet.model.Location;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login;
    Athlete athlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user =  (EditText) findViewById(R.id.usernameET);
        pass =  (EditText) findViewById(R.id.passwordET);
        login = (Button) findViewById(R.id.loginBT);
    }


    public void handleLoginClicked(View view) {

        String username = user.getText().toString();
        String password = pass.getText().toString();
        if (password.equals("pass") && username.equals("user")) {
            Intent mainView = new Intent(this, MainActivity.class);
            Athlete athlete = new Athlete("Sruti", "Guhathakurta", "sruti@gatech.edu", username, password);
            HashSet<Game> games = new HashSet<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date d_1 = sdf.parse("2016-09-27 13:30");
                Date d_2 = sdf.parse("2016-09-27 15:00");
                Date d_3 = sdf.parse("2016-09-27 17:15");
                Date d_4 = sdf.parse("2016-09-26 13:00");
                Date d_5 = sdf.parse("2016-09-26 16:00");
                Location location_1 = new Location("CRC", "750 Ferst Dr NW", 30318, "Atlanta", "GA");
                Location location_2 = new Location("North Ave Apts", "120 North Ave NW", 30313, "Atlanta", "GA");
                Location location_3 = new Location("Klaus", "266 Ferst Dr NW", 30332, "Atlanta", "GA");
                games.add(new Game(4, d_1, location_1));
                games.add(new Game(8, d_2, location_3));
                games.add(new Game(6, d_3, location_2));
                games.add(new Game(8, d_4, location_2));
                games.add(new Game(4, d_5, location_1));
                athlete.setGames(games);
                mainView.putExtra("athlete", (Serializable) athlete);
                startActivity(mainView);
            } catch (ParseException e) {
               e.printStackTrace();
            }

        } else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Incorrect Username or Password");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Okay",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    public void handleCancelClicked(View view) {
        Intent welcomeView = new Intent(this, WelcomeActivity.class);
        startActivity(welcomeView);
    }
}
