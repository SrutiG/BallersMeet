package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ballersmeet.sruti.ballersmeet.model.*;

import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchGamesActivity extends AppCompatActivity implements OnItemClickListener {

    ArrayList<Game> options;
    Athlete athlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_games);
        options = (ArrayList<Game>) getIntent().getExtras().getSerializable("options");
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        ListAdapter gameAdapter = new MyAdapter(this, options);

        ListView games = (ListView) findViewById(R.id.gamesLV);
        games.setClickable(true);
        games.setAdapter(gameAdapter);
        games.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("position", new Integer(i).toString());
        Game passGame = options.get(i);
        Intent joinGame = new Intent(this, JoinGameActivity.class);
        joinGame.putExtra("athlete", (Serializable) athlete);
        joinGame.putExtra("game", (Serializable) passGame);
        startActivity(joinGame);

    }
}
