package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.io.Serializable;

public class StartGameActivity extends AppCompatActivity {

    private Athlete athlete;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");

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
