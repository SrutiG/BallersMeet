package com.ballersmeet.sruti.ballersmeet.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Athlete athlete;
    ArrayList<Game> games;
    ArrayList<String> gameLocs;
    ArrayList<String> gameTimes;
    ArrayList<String> gameDates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
    }
}
