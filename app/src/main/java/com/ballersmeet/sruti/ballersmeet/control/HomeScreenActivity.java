package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.ParseException;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.io.Serializable;

public class HomeScreenActivity extends AppCompatActivity implements OnItemClickListener {

    Athlete athlete;
    ArrayList<Game> games;
    ArrayList<String> gameLocs;
    ArrayList<String> gameTimes;
    ArrayList<String> gameDates;
    TextView numTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        setContentView(R.layout.activity_home_screen);
        games = new ArrayList<Game>();
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
            ListAdapter gameAdapter = new MyAdapter(this, games);

            ListView games = (ListView) findViewById(R.id.gamesLV);
            games.setClickable(true);
            games.setAdapter(gameAdapter);
            games.setOnItemClickListener(this);

        } catch (ParseException e) {
            e.printStackTrace();
        }
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



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("position", new Integer(i).toString() );
        Game passGame = games.get(i);
        Intent viewGame = new Intent(this, ViewGameActivity.class);
        viewGame.putExtra("athlete", (Serializable) athlete);
        viewGame.putExtra("game", (Serializable) passGame);
        startActivity(viewGame);

    }
}
