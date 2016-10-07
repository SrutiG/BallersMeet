package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.io.Serializable;
import java.util.ArrayList;

public class JoinGameFragment extends Fragment {

    private Game game;
    private Athlete athlete;
    private TextView location, capacity, spots, date, time;
    private Button join, cancel;
    private MainActivity main;
    private ArrayList<Game> options;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_join_game, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");
        options = (ArrayList<Game>) getArguments().getSerializable("options");
        game = (Game) getArguments().getSerializable("game");
        options = (ArrayList<Game>) getArguments().getSerializable("options");
        location = (TextView) rlLayout.findViewById(R.id.locationTV);
        capacity = (TextView) rlLayout.findViewById(R.id.capacityTV);
        spots = (TextView) rlLayout.findViewById(R.id.spotsTV);
        date = (TextView) rlLayout.findViewById(R.id.dateTV);
        time = (TextView) rlLayout.findViewById(R.id.timeTV);
        join = (Button) rlLayout.findViewById(R.id.joinBT);
        cancel = (Button) rlLayout.findViewById(R.id.cancelBT);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                athlete.addGameQueue(game);
                HomeScreenFragment homeScreen = new HomeScreenFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("athlete", (Serializable)athlete);
                homeScreen.setArguments(bundle);
                homeScreen.setMain(main);
                main.setFragment(homeScreen);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("athlete", (Serializable) athlete);
                bundle.putSerializable("options", (Serializable) options);
                SearchGamesFragment search = new SearchGamesFragment();
                search.setArguments(bundle);
                search.setMain(main);
                main.setFragment(search);
            }
        });
        location.setText(game.getLocation().toString());
        capacity.setText("" + game.getNumplayers());
        spots.setText("" + game.getSize());
        date.setText(game.getDay());
        time.setText(game.getTime());
        return rlLayout;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }

}
