package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Game addedGame = (Game) getIntent().getExtras().getSerializable("game");
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        athlete.addGameQueue(addedGame);
        setContentView(R.layout.activity_game_added);
        try {
            TextView place = (TextView) findViewById(R.id.textView2);
            place.setText(addedGame.getLocation().toString());
        } catch(Exception b) {
            System.out.println("it's the textfields");
        }
    }

    public void handleHomePClick(View view) {
        Intent mainView = new Intent(this, MainActivity.class);
        mainView.putExtra("athlete", (Serializable) athlete);
        startActivity(mainView);
    }
}
