package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.io.Serializable;

public class JoinGameActivity extends AppCompatActivity {

    private Game game;
    private Athlete athlete;
    private TextView location, capacity, spots, date, time;
    private Button join, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_game);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        game = (Game) getIntent().getExtras().getSerializable("game");
        location = (TextView) findViewById(R.id.locationTV);
        capacity = (TextView) findViewById(R.id.capacityTV);
        spots = (TextView) findViewById(R.id.spotsTV);
        date = (TextView) findViewById(R.id.dateTV);
        time = (TextView) findViewById(R.id.timeTV);
        location.setText(game.getLocation().toString());
        capacity.setText("" + game.getNumplayers());
        spots.setText("" + game.getSize());
        date.setText(game.getDay());
        time.setText(game.getTime());
    }

    public void handleJoinClicked(View view) {
        athlete.addGameQueue(game);
        Intent viewHome = new Intent(this, HomeScreenActivity.class);
        viewHome.putExtra("athlete", (Serializable)athlete);
        startActivity(viewHome);

    }

    public void handleCancelClick(View view) {
        Intent viewHome = new Intent(this, HomeScreenActivity.class);
        viewHome.putExtra("athlete", (Serializable)athlete);
        startActivity(viewHome);
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
