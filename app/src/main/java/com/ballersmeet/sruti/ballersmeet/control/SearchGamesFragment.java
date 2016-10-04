package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.ballersmeet.sruti.ballersmeet.model.*;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;

import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchGamesFragment extends Fragment implements OnItemClickListener {

    ArrayList<Game> options;
    Athlete athlete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.activity_find_game, container, false);

        //options = (ArrayList<Game>) getIntent().getExtras().getSerializable("options");
        //athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        ListAdapter gameAdapter = new MyAdapter(super.getActivity(), options);

        ListView games = (ListView) rlLayout.findViewById(R.id.gamesLV);
        games.setClickable(true);
        games.setAdapter(gameAdapter);
        games.setOnItemClickListener(this);
        return rlLayout;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("position", new Integer(i).toString());
        Game passGame = options.get(i);
        Intent joinGame = new Intent(super.getActivity(), JoinGameActivity.class);
        joinGame.putExtra("athlete", (Serializable) athlete);
        joinGame.putExtra("game", (Serializable) passGame);
        startActivity(joinGame);

    }
}
