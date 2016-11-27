package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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

public class ViewGameFragment extends Fragment {

    private Game game;
    private Athlete athlete;
    private TextView location, capacity, spots, date, time;
    private Button cancel;
    private MainActivity main;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_view_game, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");
        game = (Game) getArguments().getSerializable("game");
        location = (TextView) rlLayout.findViewById(R.id.locationTV);
        capacity = (TextView) rlLayout.findViewById(R.id.capacityTV);
        spots = (TextView) rlLayout.findViewById(R.id.spotsTV);
        date = (TextView) rlLayout.findViewById(R.id.dateTV);
        time = (TextView) rlLayout.findViewById(R.id.timeTV);
        cancel = (Button) rlLayout.findViewById(R.id.cancelBT);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("athlete", (Serializable) athlete);
                HomeScreenFragment home = new HomeScreenFragment();
                home.setArguments(bundle);
                home.setMain((MainActivity) getActivity());
                main.setFragment(home);
            }
        });
        location.setText(game.getLocation().toString());
        capacity.setText("" + game.getCapacity());
        spots.setText("" + game.getNumplayers());
        date.setText(game.getDay());
        time.setText(game.getTime());
        return rlLayout;
    }


    public void setMain(MainActivity main) {
        this.main = main;
    }

}
