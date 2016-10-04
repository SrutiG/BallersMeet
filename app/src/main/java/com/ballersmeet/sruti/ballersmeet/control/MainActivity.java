package com.ballersmeet.sruti.ballersmeet.control;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {


    Athlete athlete;
    ArrayList<Game> games;
    ArrayList<String> gameLocs;
    ArrayList<String> gameTimes;
    ArrayList<String> gameDates;
    ImageButton homeBT, profileBT, searchBT, createBT;
    FrameLayout fragment;

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

    }

    public void handleImageClicked(View view) {

    }


    public void handleHomeClicked(View view) {
    }

    public void handleSearchClicked(View view) {
    }

    public void handleCreateClicked(View view) {

    }

    public void handleProfileClicked(View view) {
    }
}
