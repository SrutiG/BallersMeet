package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;
import com.ballersmeet.sruti.ballersmeet.model.Location;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends FragmentActivity {


    Athlete athlete;
    ArrayList<Game> games;
    ImageButton homeBT, profileBT, searchBT, createBT;
    FrameLayout fragment;
    ArrayList<Game> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        homeBT = (ImageButton) findViewById(R.id.homeBT);
        profileBT = (ImageButton) findViewById(R.id.profileBT);
        searchBT = (ImageButton) findViewById(R.id.searchBT);
        createBT = (ImageButton) findViewById(R.id.createBT);
        fragment = (FrameLayout) findViewById(R.id.fragment);
        games = new ArrayList<Game>();
        options = new ArrayList<Game>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d_1 = sdf.parse("2016-09-27 13:30");
            Date d_2 = sdf.parse("2016-09-27 15:00");
            Date d_3 = sdf.parse("2016-09-27 17:15");
            Date d_4 = sdf.parse("2016-09-26 13:00");
            Date d_5 = sdf.parse("2016-09-26 16:00");
            Location location_1 = new Location("CRC", "750 Ferst Dr NW", 30318, "Atlanta", "GA");
            Location location_2 = new Location("North Ave Apts", "120 North Ave NW", 30313, "Atlanta", "GA");
            Location location_3 = new Location("Klaus","266 Ferst Dr NW", 30332, "Atlanta", "GA");
            games.add(new Game(4, d_1, location_1));
            games.add(new Game(8, d_2, location_3));
            games.add(new Game(6, d_3, location_2));
            games.add(new Game(8, d_4, location_2));
            games.add(new Game(4, d_5, location_1));
            Date d_6 = sdf.parse("2016-09-26 15:00");
            Date d_7 = sdf.parse("2016-09-26 16:00");
            Location location_4 = new Location("CRC", "750 Ferst Dr NW", 30318, "Atlanta", "GA");
            Game g1 = new Game(6, d_6, location_4);
            Game g2 = new Game(10, d_7, location_4);
            options.add(g1);
            options.add(g2);


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void handleImageClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        HomeScreenFragment home = new HomeScreenFragment();
        home.setArguments(bundle);
    }


    public void handleHomeClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        HomeScreenFragment home = new HomeScreenFragment();
        home.setArguments(bundle);
    }

    public void handleSearchClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        bundle.putSerializable("options", (Serializable) options);
        FindGameFragment search = new FindGameFragment();
        search.setArguments(bundle);
    }

    public void handleCreateClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        CreateGameFragment create = new CreateGameFragment();
        create.setArguments(bundle);

    }

    public void handleProfileClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        ProfileFragment profile = new ProfileFragment();
        profile.setArguments(bundle);
    }
}
