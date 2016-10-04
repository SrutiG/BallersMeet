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
    TextView numTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        athlete = (Athlete) getArguments().getSerializable("athlete");
        games = athlete.getGames();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.activity_find_game, container, false);
        ListAdapter gameAdapter = new MyAdapter(super.getActivity(), games);
        ListView games = (ListView) rlLayout.findViewById(R.id.gamesLV);
        games.setClickable(true);
        games.setAdapter(gameAdapter);
        games.setOnItemClickListener(this);
        numTV = (TextView) rlLayout.findViewById(R.id.numTV);
        return rlLayout;
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
