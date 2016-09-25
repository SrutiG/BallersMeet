package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


import java.io.Serializable;

public class HomeScreenActivity extends AppCompatActivity {

    Athlete athlete;
    Game[] games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        setContentView(R.layout.activity_home_screen);
        games = new Game[5];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d_1 = sdf.parse("2016-09-27 13:30");
            Date d_2 = sdf.parse("2016-09-26 16:00");
            Location location_1 = new Location("CRC", "750 Ferst Dr NW", 30318, "Atlanta", "GA");
            Location location_2 = new Location("North Ave Apts", "120 North Ave NW", 30313, "Atlanta", "GA");
            Location location_3 = new Location("Klaus","266 Ferst Dr NW", 30332, "Atlanta", "GA");
            games[0] = new Game(4, d_1, location_1);
            games[1] = new Game(8, d_1, location_3);
            games[2] = new Game(6, d_2, location_2);
            games[3] = new Game(8, d_1, location_2);
            games[4] = new Game(4, d_2, location_1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void handleFindClicked(View view) {
        Intent findView = new Intent(this, FindGame.class);
        findView.putExtra("athlete", (Serializable) athlete);
        startActivity(findView);
    }

    public void handleProfileClicked(View view) {
        Intent profileView = new Intent(this, ProfileActivity.class);
        profileView.putExtra("athlete", (Serializable) athlete);
        startActivity(profileView);
    }

    public void handleStartClicked(View view) {
        Intent startView = new Intent(this, StartGameActivity.class);
        startView.putExtra("athlete", (Serializable) athlete);
        startActivity(startView);
    }




}
