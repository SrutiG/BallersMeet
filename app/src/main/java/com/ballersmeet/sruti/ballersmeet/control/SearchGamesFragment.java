package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ballersmeet.sruti.ballersmeet.model.*;

import android.support.v4.app.ListFragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;

import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchGamesFragment extends ListFragment {

    ArrayList<Game> options;
    Athlete athlete;
    ListView list;
    MainActivity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_find_game, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");
        options = (ArrayList<Game>) getArguments().getSerializable("options");
        ListAdapter adapter = new MyAdapter(inflater.getContext(), options);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int i, long id) {
        Log.d("position", new Integer(i).toString() );
        Game passGame = options.get(i);
        JoinGameFragment joinGame = new JoinGameFragment();
        Bundle bundle = new Bundle();
        Intent joinGameInt = new Intent(super.getActivity(), joinGame.getClass());
        bundle.putSerializable("athlete", (Serializable) athlete);
        bundle.putSerializable("game", (Serializable) passGame);
        bundle.putSerializable("options", (Serializable) options);
        joinGame.setArguments(bundle);
        joinGame.setMain(main);
        main.setFragment(joinGame);

    }

    public void setMain(MainActivity main) {
        this.main = main;
    }
}
