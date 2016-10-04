package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.ParseException;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.Serializable;

public class HomeScreenFragment extends Fragment implements OnItemClickListener {

    Athlete athlete;
    ArrayList<Game> games;
    ArrayList<String> gameLocs;
    ArrayList<String> gameTimes;
    ArrayList<String> gameDates;
    TextView numTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.activity_find_game, container, false);
        //athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        //games = new ArrayList<Game>();
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
            ListAdapter gameAdapter = new MyAdapter(super.getActivity(), games);
            ListView games = (ListView) rlLayout.findViewById(R.id.gamesLV);
            games.setClickable(true);
            games.setAdapter(gameAdapter);
            games.setOnItemClickListener(this);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        numTV = (TextView) rlLayout.findViewById(R.id.numTV);
        return rlLayout;
    }

    public void handleFindClicked(View view) {
        Intent findView = new Intent(super.getActivity(), FindGameFragment.class);
        findView.putExtra("athlete", (Serializable) athlete);
        startActivity(findView);
    }

    public void handleProfileClicked(View view) {
        Intent profileView = new Intent(super.getActivity(), ProfileFragment.class);
        profileView.putExtra("athlete", (Serializable) athlete);
        startActivity(profileView);
    }

    public void handleStartClicked(View view) {
        Intent startView = new Intent(super.getActivity(), CreateGameFragment.class);
        startView.putExtra("athlete", (Serializable) athlete);
        startActivity(startView);
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("position", new Integer(i).toString() );
        Game passGame = games.get(i);
        Intent viewGame = new Intent(super.getActivity(), ViewGameActivity.class);
        viewGame.putExtra("athlete", (Serializable) athlete);
        viewGame.putExtra("game", (Serializable) passGame);
        startActivity(viewGame);

    }
}
