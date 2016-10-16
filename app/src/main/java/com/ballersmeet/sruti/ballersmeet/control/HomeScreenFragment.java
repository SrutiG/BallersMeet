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
    MainActivity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        athlete = (Athlete) getArguments().getSerializable("athlete");
        games = athlete.toArray();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_home_screen, container, false);
        ListAdapter adapter = new MyAdapter(inflater.getContext(), games);
        setListAdapter(adapter);
        numTV = (TextView) rlLayout.findViewById(R.id.numTV);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }

    @Override
    public void onListItemClick(ListView l, View v, int i, long id) {
        Log.d("position", new Integer(i).toString() );
        Game passGame = games.get(i);
        ViewGameFragment viewGame = new ViewGameFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        bundle.putSerializable("game", (Serializable) passGame);
        viewGame.setArguments(bundle);
        viewGame.setMain(main);
        main.setFragment(viewGame);
    }

}
