package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;

import java.util.ArrayList;

import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.Serializable;

public class HomeScreenFragment extends ListFragment {

    Athlete athlete;
    ArrayList<Game> games;
    TextView numTV;
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        athlete = (Athlete) getArguments().getSerializable("athlete");
        games = athlete.getGames();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_home_screen, container, false);
        ListAdapter adapter = new MyAdapter(inflater.getContext(), games);
        setListAdapter(adapter);
        numTV = (TextView) rlLayout.findViewById(R.id.numTV);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int i, long id) {
        Log.d("position", new Integer(i).toString() );
        Game passGame = games.get(i);
        Intent viewGame = new Intent(super.getActivity(), ViewGameActivity.class);
        viewGame.putExtra("athlete", (Serializable) athlete);
        viewGame.putExtra("game", (Serializable) passGame);
        startActivity(viewGame);

    }

}
