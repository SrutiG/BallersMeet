package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.io.Serializable;

public class GameAdded extends AppCompatActivity implements Serializable {

    Athlete athlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
=======
        Game addedGame = (Game) getIntent().getExtras().getSerializable("game");
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
>>>>>>> 93dc0899be72b3b5545d89da5af24d3d802fa330
        setContentView(R.layout.activity_game_added);
        try {
            Game addedGame = (Game) getIntent().getExtras().getSerializable("game");
            try {
                TextView place = (TextView) findViewById(R.id.textView2);
                place.setText(addedGame.getLocation().toString());
            } catch(Exception b) {
                System.out.println("it's the textfields");
            }
        } catch(Exception a){
            System.out.println("it's the game");
        }
    }

    public void handleHomePClick(View view) {
        Intent homeView = new Intent(this, HomeScreenActivity.class);
        homeView.putExtra("athlete", (Serializable) athlete);
        startActivity(homeView);
    }
}
