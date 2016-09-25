package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;

public class FindGame extends AppCompatActivity {

    Athlete athlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_game);
        this.athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
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

    public void handleImageClicked(View view) {
        Intent viewHome = new Intent(this, HomeScreenActivity.class);
        viewHome.putExtra("athlete", (Serializable)athlete);
        startActivity(viewHome);
    }


    public void handleSearch(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d_1 = sdf.parse("2016-09-26 15:00");
            Date d_2 = sdf.parse("2016-09-26 16:00");
            Location location_1 = new Location("CRC", "750 Ferst Dr NW", 30318, "Atlanta", "GA");
            Game g1 = new Game(6, d_1, location_1);
            Game g2 = new Game(10, d_2, location_1);
            ArrayList<Game> options = new ArrayList<Game>();
            options.add(g1);
            options.add(g2);
            Intent viewSearch = new Intent(this, SearchGamesActivity.class);
            viewSearch.putExtra("options", (Serializable) options);
            viewSearch.putExtra("athlete", (Serializable) athlete);
            startActivity(viewSearch);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
