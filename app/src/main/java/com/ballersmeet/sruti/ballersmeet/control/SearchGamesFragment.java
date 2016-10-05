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

import android.support.v4.app.ListFragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchGamesFragment extends ListFragment {

    ArrayList<Game> options;
    Athlete athlete;
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.activity_find_game, container, false);
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
        Intent viewGame = new Intent(super.getActivity(), ViewGameActivity.class);
        viewGame.putExtra("athlete", (Serializable) athlete);
        viewGame.putExtra("game", (Serializable) passGame);
        startActivity(viewGame);

    }
}
