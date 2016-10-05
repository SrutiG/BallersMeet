package com.ballersmeet.sruti.ballersmeet.control;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
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
        options = new ArrayList<Game>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d_6 = sdf.parse("2016-09-26 15:00");
            Date d_7 = sdf.parse("2016-09-26 16:00");
            Location location_4 = new Location("CRC", "750 Ferst Dr NW", 30318, "Atlanta", "GA");
            Game g1 = new Game(6, d_6, location_4);
            Game g2 = new Game(10, d_7, location_4);
            options.add(g1);
            options.add(g2);
            Bundle bundle = new Bundle();
            bundle.putSerializable("athlete", (Serializable) athlete);
            HomeScreenFragment home = new HomeScreenFragment();
            home.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, home).commit();

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void handleImageClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        HomeScreenFragment home = new HomeScreenFragment();
        home.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, home).commit();
    }


    public void handleHomeClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        HomeScreenFragment home = new HomeScreenFragment();
        home.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, home).commit();
    }

    public void handleSearchClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        bundle.putSerializable("options", (Serializable) options);
        FindGameFragment search = new FindGameFragment();
        search.setArguments(bundle);
        search.setMain(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, search).commit();
    }

    public void handleCreateClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        CreateGameFragment create = new CreateGameFragment();
        create.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, create).commit();

    }

    public void handleProfileClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        ProfileFragment profile = new ProfileFragment();
        profile.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, profile).commit();
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }
}
